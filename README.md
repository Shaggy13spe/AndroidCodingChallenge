# AndroidCodingChallenge

This repository contains a starter Android project for a **time-boxed coding interview**.

The project **builds and runs out of the box** and displays a placeholder screen.  
It is intentionally incomplete — during the interview, you will implement the missing
pieces to complete the challenge.

---

## ⏱ Timebox

**30 minutes**

You are not expected to finish everything perfectly.  
We care more about **architecture, decisions, and clarity** than polish.

---

## 🎯 Goal

Build a small Android app using **Jetpack Compose**, **MVVM**, **Clean Architecture**, and **Hilt** that:

- Fetches data from a public API
- Displays it in a list
- Handles loading, error, and empty states
- Demonstrates clear separation of concerns

---

## 📡 API

Use **JSONPlaceholder** (no API key required):

```
GET https://jsonplaceholder.typicode.com/posts
```

Each post contains:
- `userId`
- `id`
- `title`
- `body`

---

## 🧱 Architecture & DI Requirements

This project is already configured to use **Hilt for dependency injection**.

You are expected to:
- Use **constructor injection** where appropriate
- Rely on the existing Hilt setup (`@HiltAndroidApp`, modules, bindings)
- Inject dependencies into ViewModels using Hilt

### Target architecture

```
UI (Compose)
  ↓
ViewModel
  ↓
UseCase
  ↓
Repository
  ↓
RemoteDataSource (API)
```

Required concepts:
- Jetpack Compose
- ViewModel
- Coroutines
- State management (`StateFlow`, `LiveData`, etc.)
- Dependency inversion
- Hilt-based dependency injection

---

## 📂 Where to work

All implementation should happen under:

```
app/src/main/java/com/greatminds/androidcodingchallenge/
```

The necessary files **already exist** and are **stubbed out** so the project builds.
Your task is to **complete and connect these files** to achieve the goals of the exercise.

You are expected to work in (at minimum):

- `model/`
- `data/`
- `domain/`
- `ui/`
- `ui/compose/`

---

## 🖥 UI Requirements

Your UI should:

- Display a list of posts using `LazyColumn`
- Show **loading**, **error**, and **empty** states
- Support refresh (pull-to-refresh or button)
- Handle item click (navigate or expand — your choice)

UI polish is **not** the focus. Clear state handling is.

---

## 🔁 Git Workflow (Required)

You will submit your work using the following approach.

### Branch workflow

A branch in the repo will be created for you

```
candidate/<your-name>
```

You need to fork the repo, do the work, and submit a PR

```
# fork on GitHub then clone your fork
git clone https://github.com/<candidate-username>/AndroidCodingChallenge.git
cd AndroidCodingChallenge

# create branch (match upstream name)
git checkout -b candidate/<your-name>

# implement work...
git add .
git commit -m "Interview submission"
git push origin candidate/<your-name>

# Open PR on GitHub:
# Base repository: Shaggy13spe/AndroidCodingChallenge
# Base branch: candidate/<your-name>        <-- important
# Compare branch: <candidate-username>/candidate/jane-doe
```
Do **not** merge your branch into `main`.

---

## 👍 Final note

There is no single correct solution.

We are interested in:

- How you structure code
- How you separate responsibilities
- How you use Hilt and MVVM effectively
- How you explain your decisions

If you run out of time, feel free to leave TODOs and explain what you would do next.

Good luck!
