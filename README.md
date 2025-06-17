# Dokumentation für die Block 5 


**Wesentlicher Unterschied:**  
- **Jest** ist ein Framework für **Unit- und Integrationstests** von JavaScript-Code (meistens für React, Node.js, etc.). Es testet einzelne Funktionen oder Komponenten ohne echten Browser.
- **Selenium** ist ein Framework für **End-to-End-Tests (E2E)**, das echte Benutzerinteraktionen im Browser automatisiert und die gesamte Anwendung wie ein Nutzer testet.

---

**Vorteile von Jest-Tests:**
- Sehr schnell, da kein Browser gestartet wird.
- Einfaches Testen von Logik, Komponenten und Funktionen.
- Gute Integration in moderne JavaScript-Projekte.
- Einfaches Mocking von Abhängigkeiten.

**Vorteile von Selenium-Tests:**
- Testen die Anwendung wie ein echter Benutzer im Browser.
- Finden Fehler, die nur im Zusammenspiel von Frontend, Backend und Browser auftreten.
- Unterstützen verschiedene Browser und Plattformen.
- Ideal für Akzeptanztests und Regressionstests.

## J-Unit Backend Tests

_Allgemein:ICh verwende JUnit und Mockito, um die Methoden getAllTasks, addTask und delTask unabhängig von der echten Datenbank zu testen. Dabei wird das TaskRepository gemockt. Die Tests prüfen, ob bei verschiedenen Szenarien (z. B. vorhandene oder nicht vorhandene ID) die richtigen HTTP-Antworten zurückgegeben werden._

1. getAllTasks_returnsTaskList
In dieser Methode werden zwei Tasks erstellt. Der Mock taskRepository.findAll() liefert diese beiden Tasks zurück. Anschliessend wird überprüft, ob der HTTP-Status 200 (OK) ist, die Liste genau zwei Einträge enthält und der erste Eintrag die korrekte Beschreibung hat.

2. addTask_savesAndReturnsTask
Diese Methode testet das Speichern einer neuen Aufgabe. Der Mock simuliert, dass nach dem Aufruf von save() eine Aufgabe mit der ID 10 zurückgegeben wird. Es wird geprüft, ob der Statuscode 200 ist, ob die zurückgegebene Aufgabe die richtige Beschreibung und ID hat und ob save() tatsächlich aufgerufen wurde.

3. delTask_existingId_deletesAndReturnsOk
Diese Methode überprüft das Löschen einer Aufgabe mit einer vorhandenen ID, zum Beispiel ID 5. Wenn die ID existiert, wird deleteById(id) aufgerufen. Es wird geprüft, ob die Methode tatsächlich aufgerufen wurde und ob der Statuscode 200 (OK) zurückgegeben wurde.


## Jest Frontend Test

- 1. Test:

Hier wird geprüft, ob das Eingabefeld und der Button korrekt gerendert werden – und ob man in das Feld etwas eintippen kann.
Die App-Komponente wird virtualisiert (gerendert), anschliessend wird nach einem Eingabefeld mit dem Label „Neues Todo anlegen“ gesucht. Danach wird der Button mit der Aufschrift „Absenden“ gesucht.
Zum Schluss wird überprüft, ob beide Elemente tatsächlich vorhanden sind.

- 2. Test:

Der zweite Test prüft, ob beim Starten der App Aufgaben geladen und angezeigt werden.
Dazu werden die erwarteten Daten eingesetzt (z. B. durch ein Mock) und anschliessend wird überprüft, ob bestimmte Aufgaben tatsächlich auf dem Bildschirm erscheinen.

## Ergebnis:
Der erste JUnit-Test funktioniert einwandfrei.
Beim zweiten Test, der mit Jest durchgeführt wurde, hatte ich allerdings Probleme, da ich die Konfigurationen nicht korrekt einstellen konnte.
Aus diesem Grund hat der zweite Test nicht wie erwartet funktioniert.
![image](https://github.com/user-attachments/assets/c77c0ffd-77f8-4dbe-866e-67cdf88b63cc)
