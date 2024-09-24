def suffle(input_list):
    output_list = [0] * len(input_list)
    for i in range(len(input_list)):
        row = i // 4
        col = i % 4
        output_list[i] = input_list[col * 4 + row]
    return output_list


list_constraint1 = []
list_constraint2 = []
list_constraint3_1 = []
list_constraint3_2 = []

input_list = ['x0'+hex(i)[-1] for i in range(16)]

for i in range(5):
    output_list = []
    a = []
    constr2 = ""
    constr3_i = ""
    constr3_o = ""
    for j in range(16):
        if (j % 4 == 0):
            a.append('a'+str(i)+hex(j//4)[-1])
        list_constraint1.append(input_list[j]+' - '+a[j//4]+' <= 0')
        output_list.append('x'+str(i+1)+hex(j)[-1])
        constr2 += input_list[j] + ' +'

        constr3_i += input_list[j] + ' +'
        constr3_o += output_list[j] + ' +'
        if (j % 4 == 3):
            constr2 = constr2[:-1]+'-'+a[-1]
            constr3_1 = '4*('+constr3_i[:-1]+') - ('+constr3_o[:-1]+') >=0'
            constr3_2 = '4*('+constr3_o[:-1]+') - ('+constr3_i[:-1]+') >=0'
            list_constraint2.append(constr2)
            list_constraint3_1.append(constr3_1)
            list_constraint3_2.append(constr3_2)
            constr2 = ""
            constr3_i = ""
            constr3_o = ""

    input_list = suffle(output_list)

# Open the output file in write mode
with open("output.txt", "w") as file:
    file.write("Subject To\n")
    # Iterate over the constraints and write them in the desired format
    for i, constraint in enumerate(list_constraint1):
        file.write(f" R{i}: {constraint}\n")

starting_index = len(list_constraint1)+1
with open("output.txt", "w") as file:
    # Iterate over the expressions and write them in the desired format
    for i, expression in enumerate(expressions):
        file.write(f" R{starting_index + i}: {expression} >= 0\n")
print("Constraints have been written to output.txt")
print(list_constraint1)
print(list_constraint2)
print(list_constraint3_1)
print(list_constraint3_2)
