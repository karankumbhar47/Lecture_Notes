-- This is a single-line comment

--[[
   This is a
   multi-line comment
--]]

-- Variables and Assignment
local a = 5
local b = "hello"
local c = true

-- Arithmetic operations
local sum = a + 10
local product = a * 3
local quotient = a / 2

-- Exponential notation
local scientific = 2.5e2

-- Conditional statements
if a > 0 then
    print("a is positive")
elseif a < 0 then
    print("a is negative")
else
    print("a is zero")
end

-- Loops
for i = 1, 5 do
    print("Loop iteration:", i)
end

local counter = 1
while counter <= 3 do
    print("While loop iteration:", counter)
    counter = counter + 1
end

-- Functions
function greet(name)
    print("Hello, " .. name .. "!")
end

-- Table and key-value pairs
local person = {
    name = "Alice",
    age = 30,
    isStudent = false
}

print(person.name)
print(person["age"])

-- String manipulation
local str1 = "Hello"
local str2 = "World"
local combinedStr = str1 .. " " .. str2

-- Concatenation
local numbers = {1, 2, 3}
local joinedNumbers = table.concat(numbers, ", ")

-- Error handling
local success, result = pcall(function()
    error("Something went wrong")
end)

if not success then
    print("Error:", result)
end

-- Scope resolution
local module = {}
module.var = 10

-- Nil value
local value = nil

-- User-defined metatable
local mt = {}
mt.__index = function(table, key)
    return "Key not found"
end

local data = setmetatable({}, mt)
print(data.someKey)
