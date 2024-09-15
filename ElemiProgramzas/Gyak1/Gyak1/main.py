# Kiíratás

print('Hello world!')

name = "Elek"

print("Hello " + name)

# f string
print(f"Hello {name}!")

text = "Ez_egy_hosszabb_szöveg"
print(text[10])
print(text[3:13])
print(text[1:13:2])
print(text[-2])

# Beolvasás

age = input("Hány éves vagy? ")
print(age)
print(type(age))

# Típusok a Pythonban

str
int
float
complex
list
dict
tuple
set
bool


# Operátorok: +  -  *   /   //  %   ** (aritmetikai operátorok)

# Feladat: Kérjük be a nevét, hogy hol született,
# hogy mikor született és írjuk ki, hogy
# Te, XY, itt és itt születtél X éve.

nev = input("Mi a neved? ")
szul_hely = input("Hol születtél? ")
szul_ev = int(input("Mikor születtél? "))

print(f"Te, {nev}, {szul_hely} településen születtél {2023-szul_ev} éve.")




