# Mi lesz a kimenet?
# 1.
var1 = 5
var2 = '5'
#print(var1 + var2)

# 2.
x = 0
a = 5
b = 5
if a > 0:
    if b < 0:
        x += 5
    elif a > 5:
        x += 4
    else:
        x += 3
else:
    x += 2
print(x)
#
# # 3.
var = 0
while var < 100:
    var += 2
print(var)
#
# # 4.
lista = [1,2,3,4]
y = 0
for i in range(1,len(lista)):
    y +=  lista[i] + lista[i-1] # 1.: y = 3 2.: 8
print(y)

# # 5.
lista = [1,22,2,3,4,4,5,6,6,77,8,9,10,10]
print(list(filter(lambda x: x%2==0, lista)))

# 6.
print(set(filter(lambda x: x%2==0, lista)))

# 7.
print(set(map(lambda x: x*10, lista)))

# Kódírás - feladatok

# 8. TAJ-szám generátor - függvénnyel valósítsuk meg.

# 1. Kérjünk be neveket konzolról.
# 2. Generáljunk hozzá TAJ-számot (9 számjegy)
#    véletlenszám-generátorral és a TAJ-számot
#    tároljuk el egy változóban.
# 3. Írjuk ki a név - TAJ-szám párokat egy dictionary-be,
# 4. majd a dictionary-t egy fájlba.
import random

def TAJ_generator():
    adatok = {}
    while True:
        name = input("Kérem a nevet: ")
        TAJ_szam = ""
        for _ in range(9):
            temp = random.randint(0,9)
            TAJ_szam += str(temp)
        adatok[name] = TAJ_szam
        run = input("Van további név? y/n  ")
        if run == "n":
            break

    celfile = open('adatok.txt', 'a', encoding='utf-8')
    for adat in adatok:
        print(f"{adat}: {adatok[adat]}", file=celfile)

TAJ_generator()
