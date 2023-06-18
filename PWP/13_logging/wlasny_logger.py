import logging

mylogger = logging.getLogger('mylogger')
mylogger.setLevel(logging.WARNING)
# wybór 'handler'ów'
c_handler = logging.StreamHandler()
f_handler = logging.FileHandler('p4.log')
# definicja formatów wiadomości
c_format = logging.Formatter('%(name)s %(levelname)s %(message)s')
f_format = logging.Formatter('%(asctime)s %(name)s %(levelname)s %(message)s')
# przypisanie formatów handlerom
c_handler.setFormatter(c_format)
f_handler.setFormatter(f_format)
# dodanie 'handler'ów' do loggera
mylogger.addHandler(c_handler)
mylogger.addHandler(f_handler)
# generowanie komunikatów
mylogger.warning('This is a warning')
mylogger.error('This is an error')
