import dis
import opcode

def generator():
  recv = yield 1
  return recv

dis.dis(generator)

gen = generator()
gen.send(None)

lasti = gen.gi_frame.f_lasti
lasti

code = gen.gi_code
code is gen.gi_frame.f_code

op = code[lasti]
opcode.opname[op]