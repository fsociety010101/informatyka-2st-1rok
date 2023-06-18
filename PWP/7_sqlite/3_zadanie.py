from sqlalchemy import Boolean, Column, ForeignKey, Integer, String, create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

engine = create_engine("sqlite:///library.db", echo=True)

Base = declarative_base()


# tables
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


# create
Base.metadata.create_all(engine)

# data records
new_book = Books(
    book_id=123,
    name="The C Programming Language",
    author="Brian Kernighan, Dennis Ritchie",
    year=1978,
    isAvailable=True,
)

new_student = Students(
    student_id=10,
    name="Jan",
    surname="Kowalski",
    faculty="Informatyka",
    phone="123456789",
)

new_borrow = BorrowRecords(
    borrow_id=1,
    student_id=new_student.student_id,
    book_id=new_book.book_id,
    fromDate="2020-01-01",
    toDate="2020-01-31",
    isReturned=False,
)

# session
Session = sessionmaker(bind=engine)
session = Session()
session.add(new_student)
session.add(new_book)
session.add(new_borrow)
session.commit()
