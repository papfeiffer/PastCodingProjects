import time


size = [1, 10, 100, 1000, 10000, 100000, 1000000, 10000000]

for n in size:

    addtoFrontList = 0
    addtoDict = 0
    delfromDict = 0
    addtoEndofList = 0
    delfromFrontofList = 0
    delfromEndofList = 0
    addtoMidofList = 0
    delfromMidofList = 0

    for i in range(0, 10):


        #Add to front of list

        time_list = []

        start = time.time()
        for i in range(n):
            var = 2                      #random variable
            time_list.insert(0, var)
        end = time.time()
        addtoFrontList += ((end - start) / n)


        #Add to dict

        dict = {}

        start = time.time()
        for i in range (n):
            dict[i] = i
        end = time.time()
        addtoDict += ((end - start) / n)


        #Delete from dict

        dict1 = {}

        for i in range(0, n):
            dict1[i] = i
        start = time.time()
        for i in range(0, n):
            del dict1[i]
        end = time.time()
        delfromDict += ((end - start) / n)


        #Add to end of list

        time_list1 = []

        start = time.time()
        for i in range(0, n):
            var = 2                      #random variable
            time_list1.append(var)
        end = time.time()
        addtoEndofList += ((end - start) / n)


        #Delete from front of list

        time_list2 = []
        for i in range (0, n):
            var = 2
            time_list2.insert(0, var)
        start = time.time()
        for i in range (0, n):
            del time_list2[0]
        end = time.time()
        delfromFrontofList += ((end - start) / n)


        #Delete from end of list

        time_list3 = []
        for i in range (0, n):
            var = 2
            time_list2.insert(0, var)
        start = time.time()
        for i in range (0, n):
            del time_list2[-1]
        end = time.time()
        delfromEndofList += ((end - start) / n)


        #Add to middle of list

        time_list4 = []

        start = time.time()
        for i in range(0, n):
            var = 2                # random variable
            time_list4.insert(len(time_list4)//2, var)
        end = time.time()
        addtoMidofList += ((end - start) / n)


        #Delete from middle of list

        time_list5 = []
        for i in range (0, n):
            var = 2
            time_list5.insert(0, var)
        start = time.time()
        for i in range(0, n):
            del time_list5[(len(time_list5)//2)]
        end = time.time()
        delfromMidofList += ((end - start) / n)



    addtoFrontList = addtoFrontList / 10
    addtoDict = addtoDict / 10
    delfromDict = delfromDict / 10
    addtoEndofList = addtoEndofList / 10
    delfromFrontofList = delfromFrontofList / 10
    delfromEndofList = delfromEndofList / 10
    addtoMidofList = addtoMidofList / 10
    delfromMidofList = delfromMidofList / 10


    print ('n = ', n)


    print ('Add to front of list:', addtoFrontList)
    print ('Add to dict:', addtoDict)
    print ('Delete from dict:', delfromDict)
    print ('Add to end of list:', addtoEndofList)
    print ('Delete from front of list:', delfromFrontofList)
    print ('Delete from end of list:', delfromEndofList)
    print ('Add to middle of list:', addtoMidofList)
    print ('Delete from middle of list:', delfromMidofList)

