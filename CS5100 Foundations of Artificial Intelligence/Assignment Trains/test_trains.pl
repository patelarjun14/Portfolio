/**
 * Autotester for the Trains Prolog assignment
 * Do not alter this file
*/

:- consult(trains).

:- begin_tests(trains).

test(link1) :- link(udistrict,universityofwashington).
test(link2) :- link(capitolhill,westlake).
test(link3, [fail]) :- link(universityofwashington,udistrict).
test(link4, [fail]) :- link(udistrict,udistrict).
test(link5) :- link(salem,albany).
test(link6) :- link(seattle,tukwila).
test(link7) :- link(bellingham,mtvernon).

test(south1, all(X == [seatacairport,anglelake])) :-  south(tukwilainternationalboulevard,X).
test(south2, all(X == [])) :-  south(anglelake,X).
test(south3, [fail]) :- south(capitolhill,universityofwashington).
test(south4, [fail]) :- south(capitolhill,capitolhill).
test(south5, nondet) :- south(vancouverbc,vancouverwa).

test(north1, all(X == [roosevelt,northgate])) :-  north(udistrict,X).
test(north2, all(X == [])) :-  north(northgate,X).
test(north3, [fail]) :- north(sodo,othello).
test(north4, [fail]) :- north(sodo,sodo).

test(connected1, nondet) :- connected(northgate,anglelake).
test(connected2, nondet) :- connected(anglelake,northgate).
test(connected3, nondet) :- connected(vancouverbc,eugene). 
test(connected4, nondet) :- connected(eugene,vancouverbc). 
test(connected5, [fail]) :- connected(vancouverbc,anglelake).
test(connected6, [fail]) :- connected(tukwila,seatacairport).

:- end_tests(trains).

:- run_tests.