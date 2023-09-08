/**
 * Prolog program to find a baseball lineup
 * @author Your Name here
 **/

% function ensuring all the members of a list are different
alldiff([H | T]) :- member(H, T), !, fail. 
alldiff([_ | T]) :- alldiff(T). 
alldiff([_]).

% function that ensures A comes before B in a given list
comesBefore([H | T], H, B) :- member(B, T).
comesBefore([_ | T], A, B) :- comesBefore(T, A , B).

% add additional KB and any predicates you may need
% adding all data from readme document
player(alvin_davis,fb,0.28,683,160,0,left).
player(ken_griffey_jr,cf,0.284,1836,630,0,left).
player(raul_ibanez,lf,0.272,1207,305,0,left).
player(kenji_johjima,c,0.268,198,48,0,right).
player(randy_johnson,p,0.125,40,1,3.05,right).
player(edgar_martinez,dh,0.312,1219,309,0,right).
player(alex_rodriguez,ss,0.295,2086,699,0,right).
player(kyle_seager,tb,0.251,807,242,0,left).
player(ichiro_suzuki,rf,0.311,780,117,9.0,left).


solution([First,Second,Third,Forth,Fifth,Sixth,Seventh,Eighth,Ninth]) :-

% this is the constraints for the first player
% The first batter should be fast to ensure they make it on plate. Your fastest players are your outfielders.
player(First,First_pos,_,_,_,_,_),
member(First_pos,[lf,cf,rf]),

% this is the constraints for the second player
% It is always best practice for the second batter to be a Lefty.
player(Second,_,_,_,_,_,Second_bats),
Second_bats = left,

% this is the constraints for the third player
% Your "three-hole" doesn't need to be very fast and you think it is best to put someone from the Infield.
player(Third,Third_pos,Third_ba,_,_,_,_),
member(Third_pos,[fb,sb,tb,ss]),

% this is the constraints for the forth player
% Fourth really should be one of your better hitters so you want them to have a better BA than the third hitter.
player(Forth,_,Forth_ba,_,Forth_hr,_,_),
Forth_ba > Third_ba,

% this is the constraints for the fifth player
% By now all of the bases are loaded so you want a someone who can hit a Home Run. 
% Pick a player who has a better HR than the fourth batter. It also serves to intimidate the opposing team's 
% Pitcher into not Walking (skipping) the fourth batter.
player(Fifth,_,_,Fifth_rbi,Fifth_hr,_,_),
Fifth_hr > Forth_hr,

% this is the constraints for the sixth player
% Sixth should have really gotten a good understanding of the opponent Pitcher and your gut tells you that 
% nobody knows Pitchers better than someone who has pitched before. Pick a player with a non-zero ERA.
player(Sixth,_,_,_,_,Sixth_era,_),
Sixth_era > 0,

% this is the constraints for the seventh player
% Seventh can be one of the weaker players (although everyone on your team is an all-star so nothing to worry 
% about). This player can have a worse BA than the fourth.
player(Seventh,_,Seventh_ba,_,_,_,_),
Seventh_ba < Forth_ba,

% this is the constraints for the eighth player
% Eighth it is safe take risks. Pick someone who always swings for the fences. Their RBI can be lower than the 
% fifth but they should have an HR higher than the fourth.
player(Eighth,_,_,Eighth_rbi,Eighth_hr,_,_),
Eighth_rbi < Fifth_rbi,
Eighth_hr > Forth_hr,

% this is the constraints for the ninth player
% Ninth is always either a Pitcher or a Designated Hitter.
player(Ninth,Ninth_pos,_,_,_,_,_),
member(Ninth_pos,[p,dh]),

% these are the final constraints
% No player can be repeated in the lineup.
% You want the veterans to show the rookies how things are done. Make sure that Alvin Davis bats before Kyle Seager.
% Fans in the stadium will be upset if Ichiro isn't put in early in the lineup. Make sure that he plays before Alvin.
alldiff([First,Second,Third,Forth,Fifth,Sixth,Seventh,Eighth,Ninth]),
comesBefore([First,Second,Third,Forth,Fifth,Sixth,Seventh,Eighth,Ninth],alvin_davis,kyle_seager),
comesBefore([First,Second,Third,Forth,Fifth,Sixth,Seventh,Eighth,Ninth],ichiro_suzuki,alvin_davis).