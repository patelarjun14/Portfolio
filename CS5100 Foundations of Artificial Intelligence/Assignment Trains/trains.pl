/**
 * Prolog program to test if trains are connected
 * @author Your Name here
 **/

% Starting code
link(northgate,roosevelt).
link(roosevelt,udistrict).
link(udistrict,universityofwashington).
link(universityofwashington,capitolhill).
link(capitolhill,westlake).
link(westlake,universitystreet).
link(universitystreet,pioneersquare).
link(pioneersquare,internationaldistrict).
link(internationaldistrict,stadium).
link(stadium,sodo).
link(sodo,beaconhill).
link(beaconhill,mountbaker).
link(mountbaker,columbiacity).
link(columbiacity,othello).
link(othello,rainierbeach).
link(rainierbeach,tukwilainternationalboulevard).
link(tukwilainternationalboulevard,seatacairport).
link(seatacairport,anglelake).



% add rest of links lightrail and amtrack

link(vancouverbc,bellingham).
link(bellingham,mtvernon).
link(mtvernon,stanwood).
link(stanwood,everett).
link(everett,edmonds).
link(edmonds,seattle).
link(seattle,tukwila).
link(tukwila,tacoma).
link(tacoma,olympia).
link(olympia,centralia).
link(centralia,kelso).
link(kelso,vancouverwa).
link(vancouverwa,portland).
link(portland,oregoncity).
link(oregoncity,salem).
link(salem,albany).
link(albany,eugene).



% South
south(X,Y) :- link(X,Y).
south(X,Y) :- link(X,Z) , south(Z,Y).

% North
north(X,Y) :- link(Y,X).
north(X,Y) :- link(Z,X), north(Z,Y).

% Connected
connected(X,Y) :- south(X,Y).
connected(X,Y) :- north(X,Y).


