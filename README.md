# AndroidCodingChallenge

This repository contains a starter Android project for a **time-boxed coding interview**.
The project builds and runs out of the box and displays a placeholder screen.

During the interview, you will implement the missing pieces to complete the challenge.

---

## ⏱ Timebox

**30 minutes**

You are not expected to finish everything perfectly.
We care more about **architecture, decisions, and clarity** than polish.

---

## 🎯 Goal

Build a small Android app using **Jetpack Compose**, **MVVM**, and **Clean Architecture** that:

- Fetches data from a public API
- Displays it in a list
- Handles loading, error, and empty states
- Demonstrates clear separation of concerns

---

## 📡 API

Use **JSONPlaceholder** (no API key required):

GET https://jsonplaceholder.typicode.com/posts

Each post contains:
- userId
- id
- title
- body

---

## 🧱 Architecture Requirements

Implement the missing code using the following layers:

UI (Compose)
↓
ViewModel
↓
UseCase
↓
Repository
↓
RemoteDataSource (API)

Required concepts:
- Jetpack Compose
- ViewModel
- Coroutines
- State management (StateFlow, LiveData, etc.)
- Dependency inversion

---

## 📂 Where to work

All implementation should happen under:

app/src/main/java/com/greatminds/androidcodingchallenge/

The files are already created for you but contain only placeholders.

---

## 🖥 UI Requirements

Your UI should:
- Display a list of posts using LazyColumn
- Show loading, error, and empty states
- Support refresh (pull-to-refresh or button)
- Handle item click (navigate or expand)

UI polish is not the focus.

---

## 🔁 Git Workflow (Required)

### Option A: Fork (preferred)

1. Fork this repository
2. Create a branch named:

candidate/<your-name>

Example:
candidate/jane-doe

3. Commit your work
4. Open a Pull Request back to the original repository

### Option B: Branch (if instructed)

git checkout -b candidate/<your-name>
git commit -am "Interview submission"
git push origin candidate/<your-name>

---

## 👍 Final note

There is no single correct solution.

We are interested in:
- How you structure code
- How you separate concerns
- How you explain your decisions

Good luck!
