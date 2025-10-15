# Shonascript Studio 🚀

Welcome to Shonascript Studio, the modern web-based IDE for the Shonascript and Shonax programming languages.

This is a complete Integrated Development Environment (IDE) built to run entirely in the browser. It provides a powerful and intuitive platform to write, run, and test Shonascript applications. Built with Vite + React, this studio offers a seamless development experience for a unique and innovative language.


**[➡️ Try the Live Demo Here!](https://shonascript-studio.pages.dev/)**


![Shonascript Studio Screenshot](/src/assets/screenshot.png)
---

## What is Shonascript?

Shonascript is a dynamic programming language designed to blend the power and flexibility of JavaScript with a more expressive, human-readable syntax. The project encompasses two distinct but related language specifications:

-   **Shonascript (`.shona`)**: A general-purpose scripting language ideal for writing logic, algorithms, and utilities. It transpiles to standard JavaScript that can run in any browser or Node.js environment.
-   **Shonax (`.shonax`)**: A superset of Shonascript designed for building reactive user interfaces. It allows you to seamlessly mix scripting logic with an HTML-like templating syntax to create interactive web components, similar to frameworks like Svelte or Vue.

All Shonascript and Shonax code is transpiled into highly optimized, standard JavaScript, ensuring broad compatibility and excellent performance.

---

## ✨ Studio Features

Shonascript Studio is more than just a text editor; it's a full-featured development environment designed to provide a complete workflow from writing code to debugging.

-   **Powerful Code Editor:** Powered by Monaco (the engine of VS Code), the editor provides syntax highlighting, auto-completion, auto-closing tags, and intelligent indentation rules for both `.shona` and `.shonax` files.
-   **Instant Live Preview:** See your `.shonax` components render in real-time as you type. The preview runs in a secure, sandboxed iframe to prevent crashes and ensure stability.
-   **Complete File Manager:** Create, rename, and delete files and folders with an intuitive file tree. Organize your project directly in the browser.
-   **Multi-File Project Support:** Build complex applications by importing components and utility functions from other files. The studio implements a sophisticated in-browser virtual module system to handle dependencies.
-   **Integrated Console:** Debug your code using a built-in console that captures `console.log`, `console.error`, and other output from your running application.
-   **Compiled JS Inspector:** Look at the generated JavaScript code to understand how your Shonascript is translated and to aid in debugging.
-   **Persistent Storage:** Your entire project, including all files and folders, is automatically saved to your browser's `localStorage`. You can close the tab and your work will be there when you return.
-   **Keyboard Shortcuts:** Boost your productivity with familiar shortcuts like `Cmd/Ctrl + S` to save and `Cmd/Ctrl + B` to toggle the file manager.

---

## 🛠️ Getting Started

To run Shonascript Studio on your local machine, follow these steps.

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/panasheMuriro/shonascript-studio.git
    cd shonascript-studio
    ```

2.  **Install dependencies:**
    This project uses `npm` as its package manager.
    ```bash
    npm install
    ```

3.  **Run the development server:**
    The studio is built with Vite, which provides a fast and efficient development experience with hot module reloading.
    ```bash
    npm run dev
    ```

4.  **Open in your browser:**
    Vite will provide you with a local URL, typically `http://localhost:5173`. Open it in your browser to start coding.

---

## ⚙️ How It Works

-   **Frontend:** The IDE is a **React** single-page application, built and served using **Vite**.
-   **Editor:** We leverage the **Monaco Editor** to deliver a professional code editing experience.
-   **Compiler Core:** The transpilation is powered by a custom compiler built with **ANTLR4**. It parses the Shonascript grammar into an Abstract Syntax Tree (AST). A custom **Visitor** (`CustomShonascriptxVisitor.js`) then traverses this tree to generate equivalent JavaScript code.
-   **Reactivity:** For `.shonax` files, the visitor generates a self-contained web component with a simple but effective reactivity system. Any state mutations within component functions automatically trigger a DOM re-render.
-   **Virtual Module System:** The live preview for multi-file projects works by pre-compiling all project files into a virtual file system. A custom module loader is injected into the preview iframe to intercept `import` statements and serve the appropriate pre-compiled code from this virtual system.

---

## 🔭 Future Plans

- This project is under active development.
- Future plans to be decided

---

## 🤝 Contributing

Contributions are welcome and greatly appreciated! If you have an idea for a new feature, find a bug, or want to improve the documentation, please feel free to:

1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/AmazingFeature`).
3.  Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4.  Push to the branch (`git push origin feature/AmazingFeature`).
5.  Open a Pull Request.

---

## 📜 License

This project is licensed under the MIT License. See the `LICENSE` file for full details.