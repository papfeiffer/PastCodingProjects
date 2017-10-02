import time

#def time_program():
time_list = []

#Insert at front of list

for i in range(0, 1):
    var = 2
    start = time.time()
    time_list.insert(0, var)
    end = time.time()
    print (end - start)

for i in range (0, 10):
   for i in range(0, 10):
    var = 2
    start = time.time()
    time_list.insert(0, var)
    end = time.time()
    print (end - start)