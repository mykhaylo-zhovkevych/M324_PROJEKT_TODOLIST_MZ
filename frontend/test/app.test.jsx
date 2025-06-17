import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom';
import App from '../src/App';

// 1 Test
test('renders input and button, allows typing', () => {
  render(<App />);
  const input = screen.getByLabelText(/Neues Todo anlegen/i);
  const button = screen.getByRole('button', { name: /Absenden/i });

  expect(input).toBeInTheDocument();
  expect(button).toBeInTheDocument();

  fireEvent.change(input, { target: { value: 'Meine Aufgabe' } });
  expect(input.value).toBe('Meine Aufgabe');
});

// 2 Test
test('fetches and displays tasks', async () => {
  render(<App />);
  
  await waitFor(() => {
    expect(screen.getByText(/Task 1: Testaufgabe 1/i)).toBeInTheDocument();
    expect(screen.getByText(/Task 2: Testaufgabe 2/i)).toBeInTheDocument();
  });
});