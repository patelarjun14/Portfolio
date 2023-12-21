/**
 * Autotester. Do not alter this file.
*/

:- consult(baseball).

:- begin_tests(baseball).

test(dif1,[fail]) :- alldiff([a,a]).
test(dif2,[fail]) :- alldiff([a,b,a]).
test(dif3,nondet) :- alldiff([a,b,c]).

test(before1,[fail]) :- comesBefore([a,b],b,a).
test(before2,nondet) :- comesBefore([a,b],a,b).


test(solve1,all(X == [[ichiro_suzuki, alvin_davis, kyle_seager, raul_ibanez, alex_rodriguez, randy_johnson, kenji_johjima, ken_griffey_jr, edgar_martinez]])) :- solution(X).

:- end_tests(baseball).

:- run_tests.
