[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=9040170&assignment_repo_type=AssignmentRepo)
# Baseball ⚾🦇💎🥜🍿🥤🏟️🚩

Topics: Constraint Programming, Scheduling, Logic Puzzle

## Pre-req

The flavor of Prolog that we will be using is SWI-Prolog [https://www.swi-prolog.org/](https://www.swi-prolog.org/). Windows installs can be found [here](https://www.swi-prolog.org/download/stable) and instructions for installing on MacOS can be found [here](https://www.swi-prolog.org/build/macos.html) (homebrew is probably easier than macports). If you're having difficulty getting a local install, try the online version [https://swish.swi-prolog.org/](https://swish.swi-prolog.org/).

## Instructions

You are the manager for an all-star version of the Seattle Mariners. Your task is to figure out a starting lineup for nine (9) of your best players and you want to use Prolog to help find a solution given your sound strategy constraints. Here are your players with statistics from [https://www.baseball-reference.com/](https://www.baseball-reference.com/):

| Player| Pos | BA | RBI | HR | ERA | Bats |
| --- | --- | --- | ---: | ---: | :---: | --- |
| Alvin Davis | 1B | 0.280 | 683 | 160 | 0 | Left |
| Ken Griffey Jr | CF | 0.284 | 1836 | 630 | 0 | Left |
| Raul Ibanez | LF | 0.272 | 1207 | 305 | 0 | Left |
| Kenji Johjima | C | 0.268 | 198 | 48 | 0 | Right |
| Randy Johnson | P | 0.125 | 40 | 1 | 3.05 | Right |
| Edgar Martinez | DH | 0.312 | 1219 | 309 | 0 | Right |
| Alex Rodriguez | SS | 0.295 | 2086 | 699 | 0 | Right |
| Kyle Seager | 3B | 0.251 | 807 | 242 | 0 | Left |
| Ichiro Suzuki | RF | 0.311 | 780 | 117 | 9.0 | Left |

Terminology: `POS` is the position they play. Outfield positions include Right Field (RF), Center Field (CF), and Left Field (LF). Infield positions are First Base (1B), Second Base (2B), Shortstop (SS), and Third Base (3B). The other three positions are the Pitcher (P), the Designated Hitter (DH), and the Catcher (C).

`BA` is the Batting Average meaning how often their turn at the plate results in a Hit. `RBI` is a confusing term meaning Runs Batted In or the number of points that have been scored because of their Hits. `HR` is a Home Run or when a Hit goes outside the field of play resulting in uncontested scoring. `ERA` is Earned Run Average but is easier to think of as a metric for how well a Pitcher is doing with lower being better (the value is zero (0) if there are no recorded pitches given by the player). Lastly, `Bats` refers to handed-ness if they prefer to swing a bat via the Right or Left side of the home plate.

*Programming Notes* : Replace any spaces in player names with underscores (_). Positions like `1B` can be identified as `fb` in Prolog because axoms cannot start with numbers.

## Manager's Constraints

There are a few rules that any good manager follows when figuring out a schedule for their team's line-up (or the order of players for them to take turns at bat). The following constraints are synthesized from [https://baseball.fandom.com/wiki/Lineup](https://baseball.fandom.com/wiki/Lineup) as well as some of your knowledge from managing your team for so many years.

1. The first batter should be fast to ensure they make it on plate. Your fastest players are your outfielders.
2. It is always best practice for the second batter to be a Lefty.
3. Your "three-hole" doesn't need to be very fast and you think it is best to put someone from the Infield.
4. Fourth really should be one of your better hitters so you want them to have a better BA than the third hitter.
5. By now all of the bases are loaded so you want a someone who can hit a Home Run. Pick a player who has a better HR than the fourth batter. It also serves to intimidate the opposing team's Pitcher into not Walking (skipping) the fourth batter.
6. Sixth should have really gotten a good understanding of the opponent Pitcher and your gut tells you that nobody knows Pitchers better than someone who has pitched before. Pick a player with a non-zero ERA.
7. Seventh can be one of the weaker players (although everyone on your team is an all-star so nothing to worry about). This player can have a worse BA than the fourth.
8. Eighth it is safe take risks. Pick someone who always swings for the fences. Their RBI can be lower than the fifth but they should have an HR higher than the fourth.
9. Ninth is always either a Pitcher or a Designated Hitter.
10. No player can be repeated in the lineup.
11. You want the veterans to show the rookies how things are done. Make sure that Alvin Davis bats before Kyle Seager.
12. Fans in the stadium will be upset if Ichiro isn't put in early in the lineup. Make sure that he plays before Alvin.

How you encode the knowledge and rules is entirely up to you. The only technical requirement is that the solution must be returned via the incomplete `solution` function. You may also not hard-code a solution.

A tester has been provided which you can run using the command:

```bash
swipl -g run_tests -t halt test_baseball.pl
```

or you can load directly from within the prolog terminal using `consult(test_baseball)` and `reconsult(test_baseball)` as needed. You may also use the command `solution(X)` which will return all of the possible solutions that meet your constraints.

## Reflection

1. What was your experience like translating English constraints into Prolog? What are your thoughts on lists in Prolog?
At first, it was dificult to understand, but it became much easier when I was able to get it to work because each step takes time to figure out. Translating english constraints is still somewhat difficult because even the slightest error such as placing a variable in the wrong place can ruin your code and debugging can be difficult. I think lists in prolog can be difficult as well because if you are analyzing a list the logic is different compared to what we do in procedural programming. When it comes to lists, procedural seems to be easier but if we have constraints declarative programming becomes easier to use.

2. You did not write this function but explain how the `comesBefore` predicate works.
The comes before predicate works by taking a list as the first parameter, a variable as the second paramter (X as before), and the another variable as the third (Y as after). The logic behind the comesBefore predicate works by using the member function to see if the variable Y is the tail of the list (meaning everything behind the head) and if the head is equal to X. If that is the case, then we know X is before Y so return true. The second part of this works recursively, which means we are repeating this process till we know X is head of the list and Y is in the tail of the list. We will remove the head and look at the second value and continue this process till we are done. If we are done if we never run into a true statement, we return false.


3. Describe how the pre-built `member` function works (see [reference documentation](https://www.swi-prolog.org/pldoc/man?predicate=member/2)).
The member function works by taking in 2 parameters. The first parameter is the variable (X) while the second parameter can be a variable or a list (better to use a list). Essentially, this function is stating "This variable X is a member of a given list". If the variable X is in the list or is in the second parameter, then the program will return true. If not, the program will return false.


4. What happens if there are multiple solutions returned by `solution`? What should you do as a manager? What actions would you take if there were no solutions returned by the program?
If there are multiple soultions based on the constraints that I believe would lead me to the most optimal lineup, then all of the solutions are equally correctly. I would pick one then adjust my constaints more if I notice I made a mistake. If there are no solutions returned by the program, then I would need to take out constraints I believe wouldn't affect the team significantly till I get a lineup.


5. What other constraints should be considered when deciding on a lineup that you think were missed or what other human factors might make this not an ideal solution?
Other constraints would be injuries if there are any players that experience anything. Even if the stats are good, there is no data on whether a player is injured. This would be critical to know and implement as a constraint. 




Go Mariners!
