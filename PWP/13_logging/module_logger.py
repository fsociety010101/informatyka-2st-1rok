import logging

import logger

logging.basicConfig(level=logging.DEBUG,
                    format='%(levelname)s:%(name)s:%(asctime)s:%(message)s', datefmt='%d-%b-%y%H:%M:%S')

logging.info('Start')
logger.mydiv(4, 0)
logging.info('End')
