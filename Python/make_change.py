def make_change(amount_charged, amount_given):
    # Dictionary to store the values of each bill/coin
    monetary_system = {
        'dollar': 100,
        'quarter': 25,
        'dime': 10,
        'nickel': 5,
        'penny': 1
    }

    change = amount_given - amount_charged
    change_breakdown = {}

    for bill, value in monetary_system.items():
        if change >= value:
            num_bills = change // value
            change_breakdown[bill] = num_bills
            change -= num_bills * value

    return change_breakdown


# Take input from the user
amount_charged = float(input("Enter the amount charged: "))
amount_given = float(input("Enter the amount given: "))

# Calculate the change breakdown
change_breakdown = make_change(amount_charged, amount_given)

print("Change breakdown:")
for bill, num in change_breakdown.items():
    print(f"{num} {bill}(s)")
