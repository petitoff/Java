Oto kilka przykładowych pytań, które mogą pojawić się podczas obrony, wraz z odpowiedziami:

Co to jest klasa SimpleDateFormat i jak jej użyć?
Odpowiedź: Klasa SimpleDateFormat jest klasą w Javie, która umożliwia formatowanie i parsowanie dat w określonym formacie. Aby użyć tej klasy, należy utworzyć nowy obiekt SimpleDateFormat i podać w konstruktorze żądany format daty. Następnie można użyć metody format() do przekształcenia daty w łańcuch znaków lub metody parse() do przekształcenia łańcucha znaków w datę.

Co to jest klasa Date i jak jej użyć?
Odpowiedź: Klasa Date jest klasą w Javie, która reprezentuje datę i czas. Aby utworzyć obiekt klasy Date, można wywołać jej konstruktor bezargumentowy, który zwróci bieżącą datę i czas, lub użyć konstruktora z argumentami, który pozwala na utworzenie daty z określonych komponentów, takich jak dzień, miesiąc, rok, godzina, minuta, sekunda. Klasa Date posiada wiele metod, które pozwalają na modyfikowanie i pobieranie poszczególnych komponentów daty i czasu.

Jak działa metoda getTime() klasy Date?
Odpowiedź: Metoda getTime() klasy Date zwraca czas w milisekundach, który upłynął od 1 stycznia 1970 roku (tzw. epoch Unix) do daty przechowywanej w obiekcie Date. Aby obliczyć różnicę między dwoma datami, można użyć tej metody na obu obiektach Date i odejmować wyniki.

Jak działa metoda convert() klasy TimeUnit?
Odpowiedź: Metoda convert() klasy TimeUnit służy do konwersji jednostek czasu. Przyjmuje dwa argumenty - wartość czasu do przeliczenia oraz jednostkę czasu, w której ta wartość jest wyrażona. Następnie zwraca wartość przeliczoną na żądaną jednostkę czasu. W programie, metoda convert() jest użyta do przeliczenia różnicy między dwoma datami w milisekundach na liczbę dni.
