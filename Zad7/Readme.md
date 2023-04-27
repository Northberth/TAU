Prosta Gra (termin oddania 11.05.2023):

1. Wygenerować planszę AxB (min 5x5). Wylosować START i STOP przy krawędzi planszy (różne pola i nie obok siebie). Losowo generujemy przeszkody, które musimy ominać.
2. Plansza powinna być do wgladu, np. wyeksportowana do pliku, wyświetlona w terminalu itp., razem ze startem np. A, stopem np. B i przeszkodami zaznaczonymi np. jako X, to dowolna konwencja. W pliku można też dodać generowane ścieżki od A do B.
3. Zasada gry jest prosta, przechodzimy od START do KONIEC na planszy, omijajac przeszkody i nie wychodzac za nia. Długość drogi nie ma znaczenia.
4. Wymagania:
W “projekcie” użyć biblioteki pythonowej PyTest.
Testy powinny testować nie tylko ścieżki, ale np. poprawność sprawdzania, czy nie wychodzimy za planszę, na przeszkodę, nie odwiedzamy pola dwa razy.
Użyć mechanizmu dynamicznego nazywania testów.
Testy powinny być w miarę możliwości sparametryzowane, a więc należy użyć markera parametrize.
Zastosować markery: skip, skipif, xfail - każdego conajmniej raz.
Użyć klas testowych do grupowania testów wg przeznaczenia.
Użyć konstrukcji setup i teardown dla: modułów, klas, metod.
