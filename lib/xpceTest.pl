akzeptiert(L) :- 
    start(S), 
    uebergang(S,L).

uebergang(X,[A|B]) :- 
      zustand(X,A,Y),
      uebergang(Y,B).

uebergang(X,[]) :- 
      endzustand(X).

zustand(1,a,2).
zustand(1,b,1).
zustand(2,a,2).
zustand(2,b,1).
 
start(1). 
endzustand(2).