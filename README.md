# Wine Direct

My first assessed Java coursework, for Programming 1 in Year 1 at Salford (November 2025). It models a small online wine shop as three classes, written and tested in BlueJ.

| Class | What it does |
|---|---|
| `WineCase` | A case of wine with a reference number, description, number of bottles and price |
| `Browser` | Someone visiting the site, with a year of birth, email, buyer ID and selected wine case |
| `Website` | Counts logins, turns browsers into buyers if they're 18 or over, handles checkout and gives every 10th login a 10% discount |

## Running it

Open the folder in BlueJ, create a `Website`, a few `Browser` objects and a `WineCase`, then call the methods from the object bench. You can also compile it from the command line:

```bash
javac *.java
```

There's no `main` method. The assessment was done through BlueJ's object bench.

See [PROCESS.md](PROCESS.md) for how it went.
