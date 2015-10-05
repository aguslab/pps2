from z3 import *
import sys
import logging

logging.basicConfig(filename='/home/galles/z3.log',level=logging.DEBUG)


def evaluar_z3( exp ):
	x,y = Ints('x y') 
	F = eval(exp)
	solve(F)	
	

logging.info('PARAMETRO: '+ sys.argv[1])
evaluar_z3 (sys.argv[1])

