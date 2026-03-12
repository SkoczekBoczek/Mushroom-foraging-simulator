# Mushroom Foraging Simulator

Projekt zrealizowany w ramach kursu **Programowanie Obiektowe**. Jest to prosta, tekstowa gra konsolowa, w której gracz wciela się w rolę zbieracza grzybów. Celem gry jest eksploracja lasu, zbieranie grzybów i zdobywanie punktów.

## Funkcjonalności

- **Eksploracja Lasu**: Poruszaj się po dwuwymiarowej mapie reprezentującej las.
- **Zbieranie Grzybów**: Znajduj i zbieraj grzyby, które pojawiają się losowo na mapie.
- **Różne Typy Grzybów**: W lesie można znaleźć trzy rodzaje grzybów:
  - **Jadalne** (`EdibleMushroom`): Dodają punkty.
  - **Trujące** (`PoisonousMushroom`): Odejmują punkty.
  - **Lecznicze** (`MedicinalMushroom`): Dają bonus punktowy.
- **Poziomy Trudności**: Wybierz jeden z dwóch trybów gry, które zmieniają częstotliwość i rodzaj pojawiających się grzybów.
- **System Punktacji**: Każdy zebrany grzyb wpływa na końcowy wynik gracza.

## Zastosowane Technologie

- **Język**: Java
- **Wersja JDK**: 11 lub wyższa

## Architektura i Wzorce Projektowe

Projekt został zbudowany w oparciu o kluczowe zasady programowania obiektowego.

### Zasady OOP

- **Dziedziczenie**: Abstrakcyjna klasa `Mushroom` jest klasą bazową dla konkretnych typów grzybów: `EdibleMushroom`, `PoisonousMushroom` i `MedicinalMushroom`.
- **Polimorfizm**: Metoda `consume(Player player)` jest zdefiniowana w klasie bazowej `Mushroom` i nadpisywana w każdej z podklas. Dlatego w zależności od typu grzyba, wywoływana jest odpowiednia logika wpływająca na punkty gracza.
- **Enkapsulacja**: Dane kluczowych klas (np. `Player`, `Forest`) są prywatne, a dostęp do nich odbywa się za pomocą publicznych metod.
- **Agregacja/Kompozycja**:
  - Klasa `Game` **składa się** z obiektów `Player` i `Forest`.
  - Klasa `Forest` **zawiera** tablicę obiektów `Mushroom`.
  - Klasa `Player` **agreguje** listę zebranych grzybów.

### Wzorce Projektowe

#### Strategy Pattern

Wzorzec ten został użyty do zarządzania logiką generowania lasu.

- **StandardForestStrategy (Normal)**: Zapewnia umiarkowaną liczbę grzybów (ok 10% szansy na pole) i równomiernym rozkładem gatunków jadalnych, trujących i leczniczych.
- **HardcoreForestStrategy (Hardcore)**: Zwiększa zagęszczenie grzybów (ok. 20%), ale zwiększa ryzyko wystąpienia trujących grzybów.

## Jak Uruchomić

1.  Otwórz terminal lub wiersz poleceń i przejdź do katalogu `src` projektu.
2.  Skompiluj wszystkie pliki Java:
    ```bash
    javac Main.java Game/*.java mushrooms/*.java
    ```
3.  Uruchom grę (będąc w katalogu `src`):
    ```bash
    java Main
    ```
