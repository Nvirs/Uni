class Date:
    def __init__(self, year, month, day):
        self.year = year
        self.month = month
        self.day = day

    def leap_year(self):
        if self.year % 4 == 0 and self.year % 100 != 0 or self.year % 400 == 0:
            return True
        else:
            return False

    def is_month_valid(self):
        return 1<=self.month <=12

    def is_day_valid(self):
        if self.leap_year() and self.month == 2:
            return 1 <= self.day <= 29
        elif not self.leap_year() and self.month == 2:
            return 1 <= self.day <= 28
        elif self.month == 4 or self.month == 6 or self.month == 9 or self.month == 11:
            return 1 <= self.day <= 30
        else:
            return 1 <= self.day <= 31

    def increment_day(self):
        self.day += 1
        if not self.is_day_valid():
            self.month += 1
            self.day = 1
            if not self.is_month_valid():
                self.year += 1
                self.month = 1



date1 = Date(2023, 11, 30)
print(date1.leap_year())
print(date1.is_month_valid())
print(date1.is_day_valid())

# for _ in range(40):
#     date1.increment_day()
#     print(f"{date1.year}  {date1.month}  {date1.day}")

date2 = Date(2023, 12, 31)

def distance_dates(date1, date2):
    counter = 0
    while True:
        date1.increment_day()
        counter += 1
        if date1.year == date2.year and date1.month == date2.month and date1.day == date2.day:
            break
    return counter

print(f"A két dátum között eltelt idő: {distance_dates(date1,date2)} nap.")

# Öröklődés
class Mammals:
    def __init__(self, species):
        self.species = species

    def give_sound(self):
        print("Minden emlős állat ad valami hangot.")

class Cat(Mammals):

    def __init__(self, species, name, color, age):
        super().__init__(species) # ősosztály konsktruktor hívása
        self.name = name
        self.color = color
        self.age = age

    # def give_sound(self):
    #     print("Miauuuuuuuu.")

cica1 = Cat("macska", "Cirmi", "fekete", 3)
print(cica1.species)
cica1.give_sound()

# Általános hibakezelés
try:
    file = open('valami.txt', 'r')
    print(file)
except Exception as ex:
    print(f"Hiba történt, {type(ex).__name__} merült fel, a hibaüzenet: {ex}")
try:
    num = 10 / 0
    print(num)
except Exception as ex:
    print(f"Hiba történt, {type(ex).__name__} merült fel, a hibaüzenet: {ex}")

# Gyakorló feladatok
# 1. Hozzunk létre egy Arucikk osztályt.
# 2. Tulajdonságai: megnevezes, mennyiseg, ar. --> __init__() metódus
# 3. Példányosítsunk
# 4. Írjunk egy ármódosító metódust az osztályba, ami paraméterként
# megkapja (%-ban) az infláció mértékét, és az ezzel megnövelt árra
# módosítja az objektum ár mezőjét.
class Arucikk:
    def __init__(self, megnevezes, mennyiseg, ar):
        self.megnevezes = megnevezes
        self.mennyiseg = mennyiseg
        self.ar = ar

    def inflacio(self, infl):
        """
        docstring
        :param infl: %-ban megadva
        :return: az új ár
        """
        self.ar = self.ar * (infl/100 + 1)
        return self.ar

arucikk1 = Arucikk("narancs", "1 kg", 600)
print(arucikk1.ar)
arucikk1.inflacio(20)
print(arucikk1.ar)

# Feladatgyűjtemény 43.:

class Book:
    stack = {}
    def __init__(self, author, title):
        self.author = author
        self.title = title

    def stack_filling(self):
        # dict_name[key] = value
        Book.stack[self.author] = self.title

book1 = Book("J. K. Rowling", "Harry potter")
book2 = Book("Dan Brown", "Deception point")
book3 = Book("Gárdonyi Géza", "Egri csillagok")

book1.stack_filling()
book2.stack_filling()
book3.stack_filling()
print(Book.stack)

# Feladatgyűjtemény 44.:
class BankAccount:
    def __init__(self, owner, accountNumber, balance):
        self.owner = owner
        self.accountNumber = accountNumber
        self.balance = balance

    def withdraw(self):
        osszeg = int(input("Mennyi pénzt szeretne kivenni? "))
        if osszeg <= self.balance:
            self.balance -= osszeg
            print(f"A tranzakció sikeres volt, új egyenlege: {self.balance}")
        else:
            print("Nem áll rendelkezés a megfelelő összeg.")
        return self.balance

    def deposit(self, amount):
        self.balance += amount
        return self.balance


szamla1 = BankAccount("Teszt Elek", 123456, 150000)
print(szamla1.balance)
#szamla1.withdraw()
szamla1.deposit(150000)
print(szamla1.balance)