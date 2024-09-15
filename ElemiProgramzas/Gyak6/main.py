# Beágyazott függvények

def outer():
    def inner():
        print("Hello world!")
    inner()

outer()

def greeting(name):
    def inner_greeting():
        print(f"Hello {name}!")
    inner_greeting()

greeting("Béla")

def nested_add(x):
    def inner(y):
        return x+y
    return inner

inner_func = nested_add(5)
print(type(inner_func))
print(inner_func(6))

# Rekurzió

# Hülye példa:

def stupid_example(num):
    print("Hello world!")
    num += 1
    if num <= 100:
        stupid_example(num)

# stupid_example(20)

# Valódi példák:
# Faktoriális - ciklussal

def factorial_ciklussal(num):
    if num == 1:
        return 1
    else:
        faktorial = 1
        for i in range(1, num+1):
            faktorial *= i
        return faktorial

print(f"5! ciklussal: {factorial_ciklussal(5)}")

# Ugyanez rekurzióval:

def factorial(num):
    if num == 1:
        return 1
    else:
        return num * factorial(num-1)

print(f"5! rekurzióval: {factorial(5)}")

# Fibonacci-sorozat
# 0  1  1  2  3  5  8  13

def fibonacci(n):
    if n <= 1:
        return n
    else:
        return fibonacci(n-1) + fibonacci(n-2)

print(fibonacci(7))

for n in range(21):
    print(fibonacci(n), end='  ')

print()

# Magasabb rendű függvények

# Magasabb rendű fgv: fgv.-t tud paraméterként fogadni
# vagy fgv-t ad vissza.

# filter()   map()    reduce()  zip()

# Lambda függvények

negyzet = lambda x: x**2
print(type(negyzet))
print(negyzet(4))

def square(x):
    return x**2

add = lambda x,y: x+y
print(add(10,20))

# filter()
# 2 paramétert vár: 1: fgv, 2: adatszerkezet
# A fgv. szerint kiszűri a megfelelő elemeket.

my_list = [1,2,2,3,4,5,7,7,99,88,100,55,6]
# Szűrjük ki a páros számokat, és mentsük el egy
# másik listában.

my_evens = list(filter(lambda x: x%2==0, my_list))
print(my_evens)

# map()
# A map is két paramétert vár (fgv, adatszerkezet),
# és minden elemre végrehajtja a paraméterként
# átadott fgv.-t.

my_map = list(map(lambda x: x%2==0, my_list))
print(my_map)

list_multiply = list(map(lambda x: x*3, my_list))
print(list_multiply)

# reduce()
# 1 db valamire redukálja le az adott adatszerkezetet

from functools import reduce

new_list = [2,6,9,5,7]

print(sum(new_list))

# Szorozzuk össze a listaelemeket.

szorzat = 1
for num in new_list:
    szorzat = szorzat * num

print(szorzat)

list_reduce = reduce(lambda x,y:x*y, new_list)
print(list_reduce)

# zip()
# Paraméterként 2 vagy több iterálható
# adatszerkezetet vár, és összefűzi eggyé.

names = ["Lutz Gizella", "Teszt Elek", "Hold Viola", "Gipsz Jakab"]
grades = [5,4,3,5]
scores = [20,30,50,10]

students = list(zip(names, grades, scores))
print(students)

# Fájlkezelés

# Beolvasás fájlból

file = open('lorem.txt', 'r', encoding='utf-8')

beolvasott_szoveg = ''.join(file.read())
print(beolvasott_szoveg)

file.close()
file = open('lorem.txt', 'r', encoding='utf-8')

szoveg_listaba = []
for sor in file:
    szoveg_listaba.append(sor)

print(szoveg_listaba)
file.close()

# Másik módszer a beolvasásra

beolvasott_szoveg2 = []
with open('lorem.txt', 'r', encoding='utf-8') as file2:
    for sor in file2:
        beolvasott_szoveg2.append(sor.strip()) # listaba
        #beolvasott_szoveg += sor.strip() # --# sztringbe

print(beolvasott_szoveg2)

# for sor in file2:
#     beolvasott_szoveg2.append(sor.strip())
#
# print(beolvasott_szoveg2)

list_szoveg = []
with open('lorem.txt', 'r', encoding='utf-8') as file3:
    for sor in file3:
        #list_szoveg.append(sor.strip()) # --> 1D lista  elemek:sorok
        #list_szoveg.append(sor.strip().split()) # --> 2D lista elemek:szavak
        list_szoveg.append(sor.strip().split('. ')) # --> 2D lista, elemek: mondatok

print(list_szoveg)

# Hány sorból áll a szöveg?

print(f"A szöveg {len(list_szoveg)} sorból áll.")

# Hány mondatból áll a szöveg?

# 1. megoldás - favágó módszer

counter_point = 0
for char in beolvasott_szoveg:
    if char =='.':
        counter_point += 1
print(f"A szöveg {counter_point} mondatból áll.")

# 2. Szebb és pythonosabb megoldás

print(f"A szöveg {beolvasott_szoveg.count('.')} mondatból áll.")

# 3. megoldás
counter_mondat = 0
for sor in list_szoveg:
    counter_mondat += len(sor)
print(f"A szöveg {counter_mondat} mondatból áll.")

# Írás fájlba

file4 = open('lorem.txt', 'a+', encoding='utf-8')

file4.write('\n1. hozzáadott sör.')
file4.writelines('\n2. sár')
print('\n3. sör', file=file4)







