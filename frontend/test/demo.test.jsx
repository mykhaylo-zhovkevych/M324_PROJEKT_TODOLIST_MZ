import Demo from "../src/Demo";

import { render, screen } from "@testing-library/react";
import "@testing-library/jest-dom/extend-expect";
import { expect } from '@jest/globals';
import { test } from '@jest/globals';

test('renders Demo title', () => {
render(<Demo />);
const linkElement = screen.getByText(/Demo/i);
expect(linkElement).toBeInTheDocument()
expect(linkElement).toBeVisible()
expect(linkElement).toHaveClass("headline")
});