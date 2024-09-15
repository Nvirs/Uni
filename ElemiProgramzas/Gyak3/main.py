# Típusok: lista
# Ciklusok
# Randomizálás

# list
# dict
# tuple
# set

#         0.        1.       2.
fruit = ["alma", "körte", "barack"]
int_list = [1,2,3,4,5]
vegyes_list = ["dinnye", 89, True]

# List: mutábilis

print(fruit[2])
print(fruit)
print(fruit[1:])
print(fruit[-1]) # a lista utolsó eleme
print(fruit[::-1])

# Ciklusok

# while

counter = 0
while counter <= 10:
    print(counter)
    counter += 1
print("-----------------------------")
# for ciklus
# számláló for

for i in range(0, 21, 2):
    print(i)

text = "Ez egy szöveges változó."

# for-each jellegű for

for char in text:
    print(char)

for i in range(0, len(text)):
    print(text[i])

# 1. feladat: járjuk be a vegyes listánkat for ciklussal

for item in vegyes_list:
    print(item)

# 2. feladat: kérjünk be egy számot a felhasználótól és döntsük el,
# hogy páros-e. Folytassuk mindaddig, míg a felhasználó szeretné.

# is_continue = True
# while is_continue:
#     number = int(input("Kérek egy egész számot! "))
#     if number % 2 == 0:
#         print("A szám páros.")
#     else:
#         print("A szám páratlan.")
#     folytatas = input("Akarod folytatni? y, n ").lower()
#     if folytatas == 'y':
#         continue
#     else:
#         print("Viszlát!")
#         is_continue = False

# Másik megoldás - végtelen ciklussal
# while True:
#     number = int(input("Kérek egy egész számot! "))
#     if number % 2 == 0:
#         print("A szám páros.")
#     else:
#         print("A szám páratlan.")
#     folytatas = input("Akarod folytatni? y, n ").lower()
#     if folytatas == 'y':
#         continue
#     else:
#         print("Viszlát!")
#         break

# Beágyazott lista
int_list_2 = [1,2,3,3,3,3,3,3,4,5,6,7,8,9]
int_list_3 = [7,8,9,10,11]
#              0.           1.
int_lists = [int_list_2, int_list_3]
print(int_lists)
print(int_lists[0][5])

# Hozzáadás listához
int_list_3.append(12)
print(int_list_3)

int_lists.append(int_list)
print(int_lists)

# Egyéb függvények
print(int_list_2.index(9)) # a megadott értékhez visszaadja a
                            # hozzátartozó indexet

print(int_list_2.count(3))
int_list_2.pop(2) # a megadott indexű elemet törli
print(int_list_2)
int_list_2.clear() # mindent töröl
print(int_list_2)

int_list_2.insert(0, 15)
print(int_list_2)

# Sztring felbontása

text2 = "Ez a, felbontandó szövegünk."
text2_bontva = text2.split(',') # split() fgv. mindig listát ad vissza
print(type(text2_bontva))
print(text2_bontva)

# Randomizálás
import random

random_szam = random.randint(1,100) # a 2. szám is inkluzív
print(random_szam)

# 3. feladat: ki fizeti az ebédet sorsoló
names_input = input("Add meg a neveket vesszővel elválasztva!")
names = names_input.split(',')
print(names)
random_name_index = random.randint(0, len(names) -1)
print(f"A vesztes, aki az ebédet fizeti: {names[random_name_index]}. Gratulálunk!")