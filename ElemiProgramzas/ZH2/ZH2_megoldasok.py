# 2023: 2. ZH: 12. hét
# Kódírás
#-------------------------------------

# 1.1: Hozzon létre egy Fruit osztályt. Az osztálynak 3 tulajdonsága legyen:
#      species (fajta), mennyiség (volume) és price (ár).
# 1.2: Példányosítsa az osztályt.
# 1.3: Írjon az osztályba egy metódust, ami az adott gyümölcs árát módosítja
# úgy, hogy bekéri a felhasználótól a módosítás összegét.

import random

class Fruit:
    def __init__(self, species, volume, price):
        self.species = species
        self.volume = volume
        self.price = price

    def modify_price(self):
        modification = int(input("Mennyivel módosítsuk az árat? "))
        self.price += modification
        return self.price


gyumolcs1 = Fruit("narancs", "1 kg", 1220)
print(gyumolcs1.price)
gyumolcs1.modify_price()
print(gyumolcs1.price)


# 2.1 Kockával dobunk egymás után 100x. Az eredményeket írjuk ki egy
#    'kocka.txt' nevű fájlba.
# 2.2 Olvassuk be a fájlt, és állapítsuk meg, melyik számot dobtuk a legtöbbször.
# 2.3 Melyik számot dobtuk utoljára?

def dice():
    # 2.1: kiírás:
    file = open('kocka.txt', 'w')
    for _ in range(100):
        dobas = random.randint(1,6)
        print(f"{dobas}", file=file)
    file.close()

    # 2.2: beolvasás, gyakoriság:
    file = open('kocka.txt', 'r')
    gyakorisag = {}
    for sor in file:
        sor = sor.strip()
        if sor in gyakorisag:
            gyakorisag[sor] += 1
        else:
            gyakorisag[sor] = 1
    print(gyakorisag)
    max_gyak = 0
    max_key = ''
    for key in gyakorisag:
        if gyakorisag[key] >= max_gyak:
            max_gyak = gyakorisag[key]
            max_key = key
    print(f"A legtöbbet dobott szám: {max_key}, {max_gyak} alkalommal dobtuk.")
    file.close()

    # 2.3: első és utolsó dobott szám
    dobott_szamok = []
    file = open('kocka.txt', 'r')
    for sor in file:
        dobott_szamok.append(sor.strip())
    print(f"A {dobott_szamok[0]} számot dobtuk először, és a {dobott_szamok[-1]} számot dobtuk utoljára.")

dice()

#--------------------------------------------------------------------------
# Kódfejtés
#-----------
# A csoport
#-----------

# 1.
x = 0
while x < 10: # az utoljára behelyettesítődő szám a 8.
    x += 2 # ez a sor még lefut
print(x) # tehát x értéke 10.
# És mivel a print() cikluson kívül van, így csak egy érték kerül kiírásra, így a kimenet: 10.


# 2.

my_dict = {1:2, 2:3, 3:1}
print(my_dict[2]) # dictionary esetén a []-ben a KULCS található, és a 2-es kulcshoz tartozó érték a 3.
# kimenet: 3


# 3.

num_list = [10,20,54,20,69,10,78,20,78]
new_numbers = set(num_list)
print(new_numbers) # kimenet: {10,20,54,69,78}
# A set ismétlődést nem enged, tehát minden elem csak egyszer fordulhat elő.
# A set jelölése: {}  !!!


# 4.
lista = [4,5,-1,44,6]
eredmeny = []
for i in range(len(lista)):
    # i nullától indul, és a listahossz-1 értékig (=4) megy (mert a range 2. száma már exkluzív!)
    # i: 0  1  2  3  4
    j = len(lista)-1-i # j értékei: 5-1-i = 4 - i
    # j: 4  3  2  1  0
    eredmeny.append(lista[j]) # a listaelemeket fordított sorrendben betesszük az eredmeny listába
print(eredmeny) # kimenet: [6, 44, -1, 5, 4]

# 5.

var1 = 5
var2 = 2
print(var1 // var2) # kimenet: 2, mert a // az egész osztás operátora, így az osztás
                    # egész része lesz a kimenet
print(var1 % var2)  # kimenet: 1, mert 5 osztva kettővel az 2, maradt az 1 (2*2 = 4).
                    # A maradék nem egyenlő a végeredmény tizedes részével!!!!!!

# 6.
my_list = [2,2,2,5,5,5]
print(sum(my_list) / len(my_list)) # kimenet: 3.5
# A listaelemek összegét osztjuk a lista hosszával.
# Tipp: ha kétféle szám található a listában, és mindkettő ugyanannyiszor fordul elő,
# akkor elegendő a két szám átlagát nézni. (5+2)/2 = 3.5

#-----------------------
# B csoport
#---------------

# 1.
x = 2
while x < 12: # az utoljára behelyettesítődő szám a 11.
    x += 1 # ez a sor még lefut
print(x) # tehát x értéke 12.
# És mivel a print() cikluson kívül van, így csak egy érték kerül kiírásra, így a kimenet: 12.


# 2.

my_dict = {2:4, 1:3, 3:1}
print(my_dict[1]) # dictionary esetén a []-ben a KULCS található, és az 1-es kulcshoz tartozó érték a 3.
# kimenet: 3


# 3.

num_list = ['a', 'b', 'c', 'a', 'a', 'c', 'd', 'e']
new_numbers = set(num_list)
print(new_numbers) # kimenet: {'a', 'b', 'c', 'd', 'e'}
# A set ismétlődést nem enged, tehát minden elem csak egyszer fordulhat elő.
# A set jelölése: {}  !!!


# 4.
lista = [7, 11, -6, 87, 25]
eredmeny = []
for i in range(len(lista)):
    # i nullától indul, és a listahossz-1 értékig (=4) megy (mert a range 2. száma már exkluzív!)
    # i: 0  1  2  3  4
    j = len(lista)-1-i # j értékei: 5-1-i = 4 - i
    # j: 4  3  2  1  0
    eredmeny.append(lista[j]) # a listaelemeket fordított sorrendben betesszük az eredmeny listába
print(eredmeny) # kimenet: [25, 87, -6, 11, 7]

# 5.

var1 = 7
var2 = 3
print(var1 % var2)  # kimenet: 1, mert 7 osztva hárommal az 2, maradt az 1 (2*3 = 6).
                    # A maradék nem egyenlő a végeredmény tizedes részével!!!!!!
print(var1 // var2) # kimenet: 2, mert a // az egész osztás operátora, így az osztás
                    # egész része lesz a kimenet

# 6.
my_list = [3,3,3,6,6,6]
print(sum(my_list) / len(my_list)) # kimenet: 4.5
# A listaelemek összegét osztjuk a lista hosszával.
# Tipp: ha kétféle szám található a listában, és mindkettő ugyanannyiszor fordul elő,
# akkor elegendő a két szám átlagát nézni. (3+6)/2 = 4.5