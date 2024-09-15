# Tuple, set és függvények

# Tuple
# Rendezett és immutábilis
# Jelölés: ()

my_tuple = (11,22,33,44,55)
print(my_tuple[0])
#my_tuple[0] = 66
print(my_tuple)

# Set - halmaz
# Jelölés: {}
# Mutábilis és rendezetlen
# Nem tartalmazhat multiplikátumokat

my_set = {"John", "Peter", "Eve", "Leslie"}
#print(my_set[1])
my_set.add("Gabriel")
print(my_set)
my_set.add("Gabriel")
print(my_set)
my_set.pop()
print(my_set)

# Halmazműveletek

number_set1 = {1,2,3,4,5,6}
number_set2 = {4,5,6,7,8,9}

print(number_set1.union(number_set2))
print(number_set1.intersection(number_set2))
print(number_set1.difference(number_set2))
print(number_set1.isdisjoint(number_set2))

for item in my_tuple:
    print(item)

for i in range(0, len(my_tuple)):
    print(my_tuple[i])


for item in my_set:
    print(item)

# Feladat 1: szűrjük ki a listából az ismétlődő elemeket és a maradékot mentsük el
# egy másik listában. Válasszuk a legegyszerűbb megoldást.

my_list = [1,2,2,2,2,3,3,4,5,6,7,7,8]
modositott_lista = list(set(my_list))
print(modositott_lista)

# Függvények

# def fv_név(paraméterek):
#    utasítások

def add(x,y):
    return x + y

print(add(12,456))
osszeg = add(21, 33)
print(osszeg)

def calculator(x,y,op):
    if op == '+':
        return x+y
    elif op == '-':
        return x-y
    elif op == '*':
        return x*y
    elif op == '/':
        return x/y
    elif op == '%':
        return x%y
    else:
        print("Ismeretlen művelet.")

print(calculator(10,20,'$'))

# Feladat 2: írjunk egy fgv.-t, ami paraméterként kap egy évszámot és
# eldönti, hogy szökőév-e.

def leap_year(year):
    if year % 4 == 0 and year % 100 != 0 or year % 400 == 0:
        return True
    else:
        return False

print(leap_year(2023))


def days_of_month(year, month):
    if leap_year(year) and month == 2:
        return 29
    match month:
        case 1: return 31
        case 2: return 28
        case 3: return 31
        case 4: return 30
        case 5: return 31
        case 6: return 30
        case 7: return 31
        case 8: return 31
        case 9: return 30
        case 10: return 31
        case 11: return 30
        case 12: return 31

print(days_of_month(2023,2))

def daysOfMonth(year,month):
    days = [31,28,31,30,31,30,31,31,30,31,30,31]
    if leap_year(year) and month == 2:
        return 29
    else:
        return days[month-1]

print(daysOfMonth(2023,2))


def subtract(x,y):
    return x-y

def multiply(x,y):
    return x*y

def divide(x,y):
    return x/y

def modulo(x,y):
    return x%y

operations = {'+': add,
              '-': subtract,
              '*': multiply,
              '/': divide,
              '%': modulo}

# num1 = float(input("Mi az első szám? "))
# for symbol in operations:
#     print(symbol, end="   ")
# operation = input("Milyen műveletet hajtsunk végre? ")
# num2 = float(input("Mi a második szám? "))
# function = operations[operation](num1,num2)
# print(function)

# Feladat 3: valósítsuk meg a mémben szereplő fgv.-t.

def HelloWorld(param):
    if param == "print":
        print("Hello World!")
    else:
        print("Fogalmam sincs mit csináljak.")

HelloWorld("print")

# Feladat 4: írjunk egy olyan fgv.-t, ami paraméterként kap
# egy sztringet és kiírja visszafele.

def string_rew(text):
    return text[::-1]

print(string_rew('rétipipitér'))

# Feladat 5: írjunk egy olyan fgv.-t a, két paramétert kap:
# egy karaktert és egy sztringet. Számolja meg a fgv. hogy az
# adott karakterből hány van az adott sztringben.

def karakter_szamolo(kar, text):
    counter = 0
    for char in text:
        if char == kar:
            counter += 1
    #return counter
    print(f"Az '{kar}' karakterből {counter}db van a szövegben.")

karakter_szamolo('a', 'abrakadabra')

# Feladat 6: írjunk fgv.-t, ami kiszámolja egy lista elemeinek
# átlagát.

def list_atlag(my_list):
    osszeg = 0
    for num in my_list:
        osszeg += num
    return osszeg / len(my_list)

num_list = [123,56,98,74]
print(list_atlag(num_list))

# Másik megoldás:

def atlag_list(my_list):
    return sum(my_list) / len(my_list)

print(atlag_list(num_list))

# Feladat 7: írjunk fgv.-t, ami kiszámolja egy dictionary
# értékeinek átlagát.

def atlag_dict(my_dict):
    osszeg = 0
    for key in my_dict:
        osszeg += my_dict[key]
    return osszeg / len(my_dict)

my_dict = {"Gipsz Jakab": 4,
           "Teszt Elek": 3,
           "Vak Bottyán": 5,
           "Hold Viola": 5,
           "Lutz Gizella": 3}

print(atlag_dict(my_dict))

# Feladat 8: írjunk fgv.-t ami eldönti egy számról, hogy
# prímszám-e.

def is_prime(num):
    for i in range(2,num):
        if num % i == 0:
            print("Nem prímszám.")
            break
        else:
            print("Prímszám.")
            break

is_prime(13)

def is_prime2(num):
    for i in range(2,num):
        if num % i == 0:
            return False
    return True

print(is_prime2(20))
