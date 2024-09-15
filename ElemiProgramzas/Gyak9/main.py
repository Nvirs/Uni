# Bináris fájlkezelés

eredeti_kep = open('Loki.jpg', 'rb')
# rb: read binary
masolat = open('Loki2.jpg', 'wb')
# wb: write binary
masolat.write(eredeti_kep.read())
eredeti_kep.close()

# Módszer 2:
import shutil

eredeti_kep = 'Loki.jpg'
masolat_kep = 'Loki3.jpg'

shutil.copy(eredeti_kep, masolat_kep)

#-----------------------------
# Írás fájlba

celfile = open('kimenet.txt', 'w', encoding='utf-8')
print('Írjunk valamit a fájlba.', file=celfile)
for i in range(2, 21):
    print(i, '. sor', file=celfile)

# Másik módszer írásra:
celfile.write('Még egy sor.')

# Feladat 1:
# 1.: Hozzunk létre egy lottoszamok nevű listát.
# 2.: A random modul használatával sorsoljuk ki 5 számot
#     1 és 90 között. Ügyeljünk arra, hogy a számok nem
#     ismétlődhetnek!
# 3.: Az 5 számot tároljuk el a lottoszamok listában.
# 4.: Írjuk ki a listát egy lottoszamok.txt fájlba.

import random

lottoszamok = []
while True:
    szam = random.randint(1,90)
    if szam not in lottoszamok:
        lottoszamok.append(szam)
    if len(lottoszamok) == 5:
        break
print(lottoszamok)

with open('lottoszamok.txt', 'a+') as lotto:
    for szam in lottoszamok:
        print(szam, file=lotto, end='  ')

#-------------------------------
# Átadás függvények között

# bad practice - global scope
numbers = [] # global scope

def filling_numbers():
    for i in range(1, 21):
        numbers.append(i)
    return numbers

filling_numbers()
print(numbers)

def using_numbers(any_list):
    new_numbers = [] # local scope
    for num in any_list:
        temp = num + 2
        new_numbers.append(temp)
    print(new_numbers)
    return new_numbers

using_numbers(numbers)

# good practice

def filling_list():
    numbers2 = [2,5,6,34,67,89,91] # local scope
    print(numbers2)
    return numbers2

filling_list()

def using_list(my_list):
    very_new_list = [] # local scope
    for num in my_list:
        temp = num + 3
        very_new_list.append(temp)
    print(very_new_list)
    return very_new_list

using_list(filling_list())

# list_pass = filling_list()
# using_list(list_pass)

# def main():
#     list_pass = filling_list()
#     using_list(list_pass)
# main()

# Feladat 2:
# 1.: Írjunk egy fgv.-t ami bekér 5 számot a
# usertől és ezt az 5 számot eltárolja egy listában.
# 2.: Írjunk egy másik fgv.-t, ami megkapja ezt
# a listát paraméterként és kiszámolja az átlagukat.

def numbers_func():
    num_list = []
    for i in range(5):
        num = int(input("Kérek egy egész számot! "))
        num_list.append(num)
    return num_list

def average(any_list):
    return sum(any_list) / len(any_list)

# print(average(numbers_func()))

def main():
    list_pass = numbers_func()
    print(average(list_pass))

#main()

# Hibakezelés
# try - except
try:
    file = open('valami.txt', 'r')
except FileNotFoundError:
    print("A fájl nem található.")
except IOError:
    print("Hiba történt a fájl írása/olvasása közben.")

try:
    number = 10 / 0
except ZeroDivisionError:
    print("Nullával nem lehet osztani.")


print("A program futása folytatódik.")

number_rnd = random.randint(1,2)
try:
    if number_rnd == 1:
        file_new = open('valami.txt', 'r')
    else:
        num2 = 10 / 0
except FileNotFoundError:
    print("A fájl nem található.")
except IOError:
    print("Hiba az olvasás során.")
except ZeroDivisionError:
    print("Nullával nem lehet osztani.")
finally: # mindenképpen lefut
    print("Azért valamit jól is csinálhatnál.")

# OOP alapok
# Programozási paradigmák: procedurális, strukturált,
# objektumorientált, funkcionális.

# 1.: Procedurális programozás:
#
# A programot eljárások (függvények) sorozataként szervezi.
# A GOTO utasítások használata (programvezérlés abszolút ugrása) lehetséges.
# Könnyen lehet zavaros és nehezen karbantartható kódokat eredményezni.
# Nyelvek: Basic, Pascal, C, Fortran

# 2.: Strukturált programozás:
#
# Az eljárások mellett hangsúlyozza a strukturált vezérlési szerkezeteket,
# mint például szekvenciák, ciklusok és elágazások.
# Kerüli a GOTO utasítások használatát.
# Célja a karbantarthatóság és az olvashatóság javítása.
# Nyelvek: C, Pascal, ALGOL, Python is lehet

# 3.: Objektumorientált programozás (OOP):
#
# Az objektumokat és osztályokat használja a programok strukturálására.
# Az objektumok tartalmazzák az adatokat és azokhoz kapcsolódó műveleteket
# (metódusok).
# Támogatja az öröklődést és a polimorfizmust.
# Nyelvek: C++, Java, C#, Python, Ruby

# 4.: Funkcionális (vagy applikatív) programozás:
#
# A programot függvényekre építi, amelyek nem mutatnak mellékhatásokat
# (tiszta függvények).
# Az adatok immutabilitása fontos.
# Magasabb rendű függvényeket előszeretettel használ.
# Nyelvek: Haskell, Lisp, Erlang, Scala, F#, és a Python is támogatja

# Építsünk házat!
# Házépítés - strukturáltan

haz1_szobak = 6
haz1_emelet = 2

# Ház 2
haz2_szobak = 8
haz2_emelet = 3


# Házépítés - objektumorientáltan

class House: # osztálydeklaráció

    def __init__(self, rooms, floors):
        self.rooms = rooms
        self.floors = floors

    def new_floor(self): # példánymetódus
        self.floors += 1


haz1 = House(6, 2) # példányosításnak
print(haz1.rooms)

haz2 = House(8, 3)
print(haz2.rooms)

print(haz1.floors)
haz1.new_floor()
print(haz1.floors)

print(haz2.floors)

class Cat:

    def __init__(self, name, color, age):
        self.name = name
        self.color = color
        self.age = age

    def give_sound(self):
        print("Miauuuuuuuu.")

cica1 = Cat("Cirmi", "fekete", 3)

class Dog():

    def __init__(self, name, color, age):
        self.name = name
        self.color = color
        self.age = age

    def give_sound(self):
        print("Vauvau.")

kutya1 = Dog("Blöki", "fehér", 4)

cica1.give_sound()
kutya1.give_sound()