from sqlalchemy import Boolean, Column, ForeignKey, Integer, String, create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

engine = create_engine("sqlite:///library2.db", echo=True)

Base = declarative_base()


class Books(Base):
    __tablename__ = "Books"
    book_id = Column(Integer, primary_key=True)
    name = Column(String(100))
    author = Column(String(100))
    year = Column(Integer)
    isAvailable = Column(Boolean)


class Students(Base):
    __tablename__ = "Students"
    student_id = Column(Integer, primary_key=True)
    name = Column(String(100))
    surname = Column(String(100))
    faculty = Column(String(100))
    phone = Column(String(100))


class BorrowRecords(Base):
    __tablename__ = "BorrowRecords"
    borrow_id = Column(Integer, primary_key=True)
    student_id = Column(Integer, ForeignKey("Students.student_id"))
    book_id = Column(Integer, ForeignKey("Books.book_id"))
    fromDate = Column(String(100))
    toDate = Column(String(100))
    isReturned = Column(Boolean)


Base.metadata.create_all(engine)
Session = sessionmaker(bind=engine)
session = Session()


def add_book(book_id, name, author, year, isAvailable):
    new_book = Books(
        book_id=book_id,
        name=name,
        author=author,
        year=year,
        isAvailable=isAvailable,
    )
    session.add(new_book)
    session.commit()


def add_student(student_id, name, surname, faculty, phone):
    new_student = Students(
        student_id=student_id,
        name=name,
        surname=surname,
        faculty=faculty,
        phone=phone,
    )
    session.add(new_student)
    session.commit()


def add_borrow_record(borrow_id, student_id, book_id, fromDate, toDate, isReturned):
    new_borrow = BorrowRecords(
        borrow_id=borrow_id,
        student_id=student_id,
        book_id=book_id,
        fromDate=fromDate,
        toDate=toDate,
        isReturned=isReturned,
    )
    session.add(new_borrow)
    session.commit()


print("\n\n\n\n")
while True:
    print("Hello, welcome to the library!\nChoose an option:")
    print("1. Add a book")
    print("2. Add a student")
    print("3. Add a borrow record")
    print("4. Exit")
    choice = input("Your choice: ")
    if choice == "1":
        book_id = input("Book ID: ")
        name = input("Name: ")
        author = input("Author: ")
        year = input("Year: ")
        isAvailable = input("Is available? (True/False): ")
        if isAvailable == "True":
            isAvailable = True
        else:
            isAvailable = False
        add_book(book_id, name, author, year, isAvailable)
    elif choice == "2":
        student_id = input("Student ID: ")
        name = input("Name: ")
        surname = input("Surname: ")
        faculty = input("Faculty: ")
        phone = input("Phone: ")
        add_student(student_id, name, surname, faculty, phone)
    elif choice == "3":
        borrow_id = input("Borrow ID: ")
        student_id = input("Student ID: ")
        book_id = input("Book ID: ")
        fromDate = input("From date: ")
        toDate = input("To date: ")
        isReturned = input("Is returned? (True/False): ")
        if isReturned == "True":
            isReturned = True
        else:
            isReturned = False
        add_borrow_record(borrow_id, student_id, book_id, fromDate, toDate, isReturned)
    elif choice == "4":
        exit()
