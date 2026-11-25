# How I built it

This project was about getting three classes to work together and deciding which object is responsible for what.

## How it fits together

- `WineCase` is plain data with getters.
- `Browser` has two constructors: one for someone who already has a buyer ID, and one for a new visitor who doesn't.
- `Website` holds the rules: the 18+ check in `becomeBuyer`, `buyerLogin`, `checkout` and the 10% discount.
- `Browser` and `Website` hold references to each other. When `checkout` finishes, it clears both (`setWebsite(null)` and `setWineCase(null)`), which logs the buyer out.
- I tested it by hand in BlueJ, creating objects and calling methods in different orders.

## Mistakes

- **A broken copy later on.** In January I copied this project to reuse in Programming 2 and edited it without version control. That copy ended up with two `Browser(int, String)` constructors and `Random rand` / `int newID` declared twice in `becomeBuyer`, so it didn't compile at all. The version in this repo is the one I submitted in November, which does compile. That mess is a big reason I now keep things in Git.

## Things I'd fix now

- **Money as `double`.** Prices are `double`, so 10% off can print as something like `£13.499999999`. I should store pence as an `int` or use `BigDecimal`.
- **The discount logic.** `checkHitDiscount()` checks the total login count at checkout time, not the count when that buyer logged in. If someone else logs in between your login and your checkout, the discount goes to the wrong person.
- **Random IDs can repeat.** Buyer IDs are a random number from 1000 to 9999, and nothing checks for duplicates. I fixed this exact problem in Programming 2 with a `HashSet` of used IDs.
- **Age is approximate.** `getAge()` uses birth year only, so someone who turns 18 later this year passes the check early.
