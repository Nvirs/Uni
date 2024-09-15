# Változók, operátorok, legegyszerűbb elágazás

# aritmetikai operátorok:
# +    -   *   /   //   %   **
print(5 ** 2)

print( (4 + 6) * 3)

szam = 2
szam -= 10
print(szam)

# Feladat 1: kérjünk be egy kétjegyű számot. Adjuk össze és írassuk ki
# a számjegyeinek összegét.

# num_twodigit = input("Kérek egy kétjegyű számot! ")
# print(int(num_twodigit[0]) + int(num_twodigit[1]))

# + és *: overload-olt operátorok

# kar = 'a' * 5
# print(kar)

# Logikai operátorok
# and   or   not    ^
# Relációs operátorok: <    >   <=   >=   !=

num1 = 10
num2 = 20

bool1 = num1 < num2  # True
bool2 = num1 == 25   # False
print(bool1 ^ bool2)

# Legegyszerűbb elágazás:  if  - else

# if condition:
#     do this
# else:
#     do this

# Feladat 2: páros vagy páratlan?
number = 346

if number % 2 == 0:
    print("A szám páros.")
else:
    print("A szám páratlan.")

# Feladat 3: BMI kalkulátor
# Kérjük be a magasságot méterben, a súlyt kilogramban
# < 18.5 - sovány
# 18.5 - 25: normál testalkat
# > 25: túlsúly
# BMI = súly/(magasság ** 2)

# height = float(input("Add meg a magasságot méterben: "))
# weight = float(input("Add meg a súlyt kilogramban: "))
# bmi= round(weight / height ** 2, 2)
# print(f"BMI: {bmi}")
# if bmi < 18.5:
#     print("Sovány.")
# elif bmi > 18.5 and bmi < 25:
#     print("Normál testalkat.")
# else:
#     print("Túlsúly.")

# Feladat 4: döntsük el egy évről, hogy szökőév-e.
# Mikor szökőév: osztható néggyel DE nem osztható 100-zal
# VAGY osztható 400-zal.

year = 2018
if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0:
    print("Szökőév.")
else:
    print("Nem szökőév.")


# Feladat 5: hullámvasút pénztár
# Magasság >= 120 cm --> mehet kipróbálni
# Életkor: diákjegy: 23 évig --> 500 Ft a jegy
# felnőttjegy: 24 - 65  --> 1500 Ft
# nyugdíjas: 65 felett --> 700 Ft

# print("Üdvözlünk a hullámvasúton!")
# height = int(input("Hány cm magas vagy? "))
# if height >= 120:
#     print("Szuper, kipróbálhatod a hullámvasutat!")
#     age = int(input("Hány éves vagy? "))
#     if age < 24:
#         print("500 Ft a jegyár.")
#     elif  24 <= age < 65:  #  elif age >= 24 and age < 65:
#         print("1500 Ft a jegyár.")
#     else:
#         print("700 Ft a jegyár.")
# else:
#     print("Sajnos nem próbálhatod ki a hullámvasutat.")


# Feladat 6: pizza rendelés
# Kérdezzük meg a pizza méretét: S, M, L:  1500, 2000, 2500 Ft
# Extra sajt: +300 Ft
# Pepperoni: S --> +100 Ft, M, L --> +200 Ft
# Írassuk ki a végösszeget.

# size = input("Milyen pizzát szeretnél? S, M, L: ")
# pepperoni = input("Szeretnél pepperonit a pizzádra? Y, N: ")
# extra_cheese = input("Kérsz rá extra sajtot? Y, N: ")
# bill = 0
# if size == 'S':
#     bill += 1500
# elif size == 'M':
#     bill += 2000
# else:
#     bill += 2500
#
# if pepperoni == 'Y' and size == 'S':
#     bill += 100
# if pepperoni == 'Y' and (size == 'M' or size == 'L'):
#     bill += 200
#
# if extra_cheese == 'Y':
#     bill += 300

# print(f"A számla végösszege: {bill}Ft.")

# Feladat 7: Love score kalkulátor
# count() fgv.
# lower()  - upper()

name1 = input("Mi a neved? ").lower()
name2 = input("Mi a kiszemelted neve? ").lower()

count_t = name1.count('t') + name2.count('t')
count_r = name1.count('r') + name2.count('r')
count_u = name1.count('u') + name2.count('u')
count_e = name1.count('e') + name2.count('e')
count_l = name1.count('l') + name2.count('l')
count_o = name1.count('o') + name2.count('o')
count_v = name1.count('v') + name2.count('v')

# Love score értékünk: 2 számjegy
# első számjegy: első szóból (true)
# második számjegy: második szóból (love)

love_score_first_digit = count_t + count_r + count_u + count_e
love_score_second_digit = count_l + count_o + count_v + count_e
if love_score_first_digit * 10 + love_score_second_digit >= 100:
    love_score_first_digit = 10
    love_score_second_digit = 0
    print(f"A love score értéketek 100%.")
else:
    print(f"A love score értéketek: {love_score_first_digit}{love_score_second_digit}%.")



