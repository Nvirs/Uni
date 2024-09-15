#Félévközi ZH:

#---------------------------------------------
# Megoldások 1:
#--------------

# 1.1: Olvassuk be a countries.txt file-t és tároljuk el egy megfelelő
# változóban.

orszagok = []

with open('countries.txt', 'r', encoding = 'utf-8') as file:
    for sor in file:
        # Split-eljünk a : mentén.
        orszagok.append(sor.strip().split(': '))
print(orszagok) # 2D lista --> 1D listákből áll, ahol az első elem (index0): országnév,
                                                # a 2. elem (index1): évszámok

# 1.2. Hány országban járt?
print(f"{len(orszagok)} országban járt.")

# 1.3. Melyik országban járt legtöbbször?
hossz = 0
legtobbszor_latogatott = ''
for orszag in orszagok:
    if len(orszag[1]) >= hossz:
        hossz = len(orszag[1]) # az évszámokat tartalmazó listaelem
        legtobbszor_latogatott = orszagok[orszagok.index(orszag)][0]

print(f"A legtöbbször meglátogatott ország {legtobbszor_latogatott} volt.")

# 1.4. Mely országokban járt 2015-ben?
orszagok_2015 = ''
for orszag in orszagok:
    if '2015' in orszag[1]:
        orszagok_2015 += orszagok[orszagok.index(orszag)][0]
        orszagok_2015 += ' '

print(f"2015-ben a következő országokban járt: {orszagok_2015}")

# 1.5. Mikor járt az USA-ban?

for orszag in orszagok:
    if orszag[0] == 'USA':
        print(f"{orszag[1]}-ben járt az USA-ban.")

# 1.6. Mely országokban járt csak egyszer?
orszag_egyszer = ''
for orszag in orszagok:
    if len(orszag[1]) == 4: # Ahol csak egyszer járt, ott az 1D lista 2. eleme
                            # 1 db évszám lesz, tehát 4 karakterből fog állni
        orszag_egyszer += orszag[0]
        orszag_egyszer += ' '
print(f"A következő országokban járt csak egyszer:{orszag_egyszer}")

#-------------------------------------------------------

# Megoldások 2:
#--------------
# Itt nem a ': ' szerint split-elünk, hanem a default space mentén:

# 1.1.
orszagok2 = []
with open('countries.txt', 'r', encoding='utf-8') as file2:
    for sor in file2:
        orszagok2.append(sor.strip().split()) # 2D lista szintén.
                            #Az 1D lista elemei: országnév és évszámok külön-külön
print(orszagok2)

# 1.2. Hány országban járt?

print(f"{len(orszagok2)} országban járt.")

# 1.3. Hol járt legtöbbször?
hossz2 = 0
index_orszag = 0
for orszag in orszagok2:
    if len(orszag) >= hossz:
        hossz = len(orszag)
        index_orszag = orszagok2.index(orszag)

print(f"A legtöbbször látogatott ország: {orszagok2[index_orszag][0].strip(':')}")

# 1.4. 2015-ben hol járt?
orszagok_2015_2 = ""
for orszag in orszagok2:
    for elem in orszag:
        if '2015' in elem:
            orszagok_2015_2 += orszag[0].strip(':') # Elimináljuk a felesleges : karaktert.
            orszagok_2015_2 += '  '
print(orszagok_2015_2)

# 1.5: Mikor járt az USA-ban?

for orszag in orszagok2:
    if orszag[0].strip(':') == 'USA':
        for elem in range(1, len(orszag)):
            print(orszag[elem], end=' ')
        print('-ban járt az USA-ban.')

# 1.6.: Hol járt csak egyszer?
print(f"A következő országokban járt egyszer: ", end=' ')
for orszag in orszagok2:
    if len(orszag) == 2: # Ahol egyszer járt, ott az 1D lista az országnévből
                         # és egy évszámból áll, tehát a hossza 2 lesz.
        print(orszag[0].strip(':'), end=' ')

#-------------------------------------------------------------------

# Megoldások 3:
#--------------

# 1.1: Fájl beolvasása
with open('countries.txt', 'r') as file:
    lines = file.readlines()

# Feladat 1.2: Hány országban járt az illető?
countries_visited = set()
for line in lines:
    parts = line.strip().split(':')
    country = parts[0].strip()
    countries_visited.add(country)

num_countries_visited = len(countries_visited)
print(f'1: Az illető {num_countries_visited} országban járt.')

# Feladat 1.3: Melyik országban járt legtöbbször?
country_counts = {}
for line in lines:
    parts = line.strip().split(':')
    country = parts[0].strip()
    years = [int(year.strip()) for year in parts[1].split(',')]
    country_counts[country] = len(years)

most_visited_country = max(country_counts, key=country_counts.get)
print(f'2: Legtöbbször járt ország: {most_visited_country}')

# Feladat 1.4: Mely országokban járt 2015-ben?
countries_visited_2015 = []
for line in lines:
    parts = line.strip().split(':')
    country = parts[0].strip()
    years = [int(year.strip()) for year in parts[1].split(',')]
    if 2015 in years:
        countries_visited_2015.append(country)

print(f'3: Az illető 2015-ben a következő országokban járt: {", ".join(countries_visited_2015)}')

# Feladat 1.5: Mikor járt az USA-ban?
usa_years = []
for line in lines:
    parts = line.strip().split(':')
    country = parts[0].strip()
    years = [int(year.strip()) for year in parts[1].split(',')]
    if country == 'USA':
        usa_years.extend(years)

print(f'4: Az illető az USA-ban járt ezekben az években: {", ".join(map(str, usa_years))}')

# Feladat 1.6: Mely országokban járt csak egyszer?
once_visited_countries = [country for country, count in country_counts.items() if count == 1]
print(f'5: Az illető az alábbi országokban járt csak egyszer: {", ".join(once_visited_countries)}')

#------------------------------------------------------------------------------------

# 2. Írjon egy függvényt, ami paraméterként kap egy listát, és megmondja,
# hogy hány páros ill. páratlan számot tartalmaz, és szétválogatja
# külön-külön listába a páros-páratlan számokat.
# Tipp: használja a megfelelő magasabb rendű fgv.-t-

def odd_evens(my_list):
    evens = list(filter(lambda x: x%2 == 0, my_list))
    odds = list(filter(lambda x: x%2 != 0, my_list))
    print(f"\nA páros számok száma: {len(evens)}, a páratlanok száma: {len(odds)}")
    print(f"Páros számok: {evens}")
    print(f"Páratlan számok: {odds}")

odd_evens([1,11,2,22,3,33,4,44,5,55,6,66,7,77,8,88,9,99])

# 3. Írjon egy függvényt, ami egy adott szövegben megfordítja a szavak
# karaktereit (fordítva írja ki), de a szavak sorrendje nem változik.

def rew_string(sztring):
    szavak = sztring.lower().strip().split()
    for szo in szavak:
        print(szo[::-1], end=' ')

rew_string("Géza kék az ég.")















