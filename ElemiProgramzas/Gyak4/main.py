penztar = [
    ["kenyér", "tej", "alma", "sajt", "kenyér"],
    ["étolaj", "rizs", "banán", "kenyér", "krumpli"],
    ["krumpli", "tojás", "körte", "banán", "krumpli"]
]

# Feladatok
# 1.: Hányan vásároltak a pénztárnál?

vasarlok_szama = 0

for vasarlo in range(len(penztar)):
    vasarlok_szama += 1
print(f"{vasarlok_szama} vevő fizetett.")

# másik megoldás

print(f"{len(penztar)} vevő fizetett.")

# 2. Hányan vettek kenyeret?

#print(penztar.count("kenyér"))

counter_kenyer = 0
for vasarlo in penztar:
    if vasarlo.count("kenyér") > 0:
        counter_kenyer += 1
    # for item in vasarlo:
    #     if item == "kenyér":
    #         counter_kenyer += 1
    #         break
print(f"{counter_kenyer} vásárló vett kenyeret.")

# 3. Hányadik vevő vett krumplit?

vasarlo_index = 0
break_flag = False
for vasarlo in penztar:
    if not break_flag:
        vasarlo_index += 1
        for item in vasarlo:
            if item == "krumpli":
                print(f"{vasarlo_index}. vevő vett krumplit.")
                break_flag = True
                break

# Másik megoldás:

item = "krumpli"
index_vasarlo = 0

for row in penztar:
    if item in row:
        index_vasarlo = penztar.index(row) + 1
        break
print(f"Másik megoldással: {index_vasarlo}. vevő vett étolajat.")

# 3. megoldás
# Listaértelmezés - list comprehension
# szitaxis: lista_név = [ez_megy_a_listába for ciklusváltozó in / in range() if feltétel]

index_vasarlo2 = [penztar.index(row) + 1 for row in penztar if item in row]
print(index_vasarlo2[0])


# Dictionary - szótár
# key - value / kulcs - érték párokból áll.
# Mutábilis és rendezetlen
# key: egyedinek kell lennie, de lehet a típusa int, float, bool, str...
# de nem lehet konténer típus (list, dict, set...)
# value: bármi lehet
# jelölése: {}

my_dict = {'key1': 'value1', 'key2': 'value2', 'key3': 'value3'}
print(my_dict['key1'])
my_dict['key4'] = 'value4'
print(my_dict)
my_dict['key4'] = 'value5'
print(my_dict)

capitals = {'USA': 'Washington',
            'Hungary': 'Budapest',
            'Germany': 'Berlin',
            'France': 'Paris'}

print(capitals)
capitals['Australia'] = 'Sydney'
print(capitals)
capitals['Australia'] = 'Canberra'
print(capitals)

# Legfontosabb metódusai:
# clear() --> mindent töröl
# copy() --> másolatot hoz létre
# get(key) --> visszaadja a kulcshoz tartozó értéket
# items() --> minden elemét visszaadja (kulcs:érték párok)
# pop(key) --> adott elemet töröl
# popitem() --> az utolsó elemet törli
# keys() --> kulcsokat adja vissza
# values() --> értékeket adja vissza

# A dict bejárása:

for key in capitals:
    print(key) # --> csak kulcsok
    print(capitals[key]) # --> csak értékek
    print(f"{key}: {capitals[key]}") # --> mindkettő

arak = {"alma": 360,
        "tej": 670,
        "kenyér": 550,
        "étolaj": 980,
        "rizs": 450,
        "banán": 720,
        "sajt": 2450,
        "tojás": 60,
        "körte": 357,
        "krumpli": 630
        }

# Feladat: a penztar beágyazott listát és arak dictionaryt
# figyelembe véve nyomtassunk minden vevőnek blokkot.
# Írjuk ki a végösszeget minden esetben.
print("---------------------------------------")

osszeg = 0 # A végösszeg vevőnkét.

for vevo in penztar: # végigmegyünk a pénztáron
    print(f"{penztar.index(vevo) + 1}: vásárló:")
    for termek in range(len(vevo)): # végigmegyünk a belső listákon
        osszeg += arak[vevo[termek]]
        print(f"{vevo[termek]}: {arak[vevo[termek]]}Ft.")
    print(f"A számla végösszege: {osszeg}Ft.")
    osszeg = 0

