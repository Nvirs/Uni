# Gyakorlás a ZH-ra.

# Hogyan működik a split() fgv.?
# 1.: Az argumentumként megadott határoló karakter mentén felbontja a szöveget.
# 2.: Mindig egy listát ad vissza.
# 3.: Maga a határoló karakter eliminálva lesz (ti. eltűnik a szövegből).
# 4.: Ha nem adunk meg határoló karaktert, akkor a default a space.

# Példák:

minta_szoveg = 'Ez egy mintaszöveg, a split() függvény működésére. Továbbá, a határoló karakterek gyakorlására.'

# Bontsuk fel szavanként:
szavankenti_lista = minta_szoveg.split()
print(szavankenti_lista)

# Bontsuk tagmondatokra (vessző mentén):
tagmondatok_listaja = minta_szoveg.split(',')
print(tagmondatok_listaja)

# Bontsuk mondatokra:
mondatok_listaja = minta_szoveg.split('.')
print(mondatok_listaja)

# Felbontás több karakter mentén. Legyen szavankénti felbontás mint az
# első esetben, de úgy, hogy elimináltuk a vesszőket:

felbontas_elso_karakter = minta_szoveg.split(',') # --> még 1D lista
felbontas_masodik_karakter = [] # --> már 2D lista!
for tagmondat in felbontas_elso_karakter:
    felbontas_masodik_karakter.append(tagmondat.split())

print(felbontas_masodik_karakter)
#------------------------------------------------------

# Feladatok

# 1.: Olvassuk be a vers.txt fájlt.

with open('vers.txt', 'r', encoding='utf-8') as file:
    # file: io.TextIOWrapper objektum
    vers = []  # Ebben tároljuk majd a szöveget soronként. 1sor: a lista 1 eleme.
    vers_szavanként = []  # Ebben tároljuk a verset szavanként, ez már 2D lista lesz.
    # Első dimenzió: a vers soronként
    # Második dimenzió: a vers sorai szavanként.
    # Sorról sorra haladunk:
    for sor in file:
        vers.append(sor.strip())
        vers_szavanként.append(sor.strip().split())
print(vers)
print(vers_szavanként)

# Beolvasás string változóba:

with open('vers.txt', 'r', encoding='utf-8') as file:
    vers_string = ''
    for sor in file:
        vers_string += sor.strip()

print(vers_string)

# 2.: Hány mondatból áll a vers?
counter = 0
for char in vers_string:
    if char == '.' or char == '!' or char == '?':
        counter += 1

print(f"A vers {counter} mondatból áll.")

# 3.: Melyik a leghosszabb sor és hány karakterből áll?
leghosszabb_sor = ''
for  sor in vers:
    if len(sor) >= len(leghosszabb_sor):
        leghosszabb_sor = sor.strip()

print(f"A leghosszabb sor: {leghosszabb_sor}; {len(leghosszabb_sor)} karakterből áll.")
#--------------------------------------------------------------

# Oldjuk meg a kilépő ZH első feladatát!

# 1.1 - 1.2: Olvassuk be és tároljuk el a lorem.txt fájlt, majd írassuk ki.

with open('lorem.txt', encoding='utf-8') as file:
    text = ''
    for sor in file:
        text += sor

print(f"1.1: A beolvasott szöveg: {text}")


# 1.3: Hány db 'a' karakter van a szövegben?
print(f"1.2: {text.count('a')} db 'a' karakter található a szövegben.")


# 1.4: Hány szóból és mondatból áll a szöveg?
print(f"1.3: {text.count(' ') +1} szóból és {text.count('.')} mondatból áll a szöveg.")
# Az utolsó szó nincs már megszámolva, mert nincs utána space. Ezért kell a +1.



# 1.5: Írassuk ki csak az 'x' karaktert tartalmazó szavakat.
# 1.6: Hány ilyen szó van?
print("1.4:")
with open("lorem.txt", encoding='utf-8') as words:
    word_list = []
    for word in words:
        word = word.strip().split(' ')
        word_list.append(word)

count_x = 0
for words in word_list:
    for word in words:
        for char in word:
            if char == 'x':
                count_x += 1
                print(word)
                break

print(f"1.5: {count_x} szó tartalmaz 'x' karaktert.")

# 1.7: Hányadik szó az első 'x' karaktert tartalmazó szó?
# Csak az első ilyen szót találjuk meg és írassuk ki!

count_word = 0
break_flag = False
for words in word_list:
    for word in words:
        count_word += 1
        for char in word:
            if char == 'x':
                print(f"1.6: A/z {count_word}. szó az első 'x'-et tartalmazó szó.")
                break_flag = True
                break
        if break_flag == True:
            break
    if break_flag == True:
        break
