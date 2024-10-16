class CreditCard:
    """A consumer credit card."""

    def __init__(self, customer, bank, acnt, limit):
        """Create a new credit card instance.

        The initial balance is zero.

        customer the name of the customer (e.g., 'John Smith')
        bank     the name of the bank (e.g., 'California Savings')
        acnt     the acount identifier (e.g., '5399 0375 9387 5309')
        limit    credit limit (measured in dollars)
        """

        self._customer = customer
        self._bank = bank
        self._account = acnt
        self._limit = limit
        self._balance = 0

    def get_customer(self):
        """Return name of the customer."""
        return self._customer

    def get_bank(self):
        """Return the bank's name."""
        return self._bank

    def get_account(self):
        """Return the card identifying number (typically stored as a string)."""
        return self._account

    def get_limit(self):
        """Return current credit limit."""
        return self._limit

    def get_balance(self):
        """Return current balance."""
        return self._balance

    def charge(self, price):
        """Charge given price to the card, assuming sufficient credit limit.

        Return True if charge was processed; False if charge was denied
        """

        if price + self._balance > self._limit:
            return False
        else:
            self._balance += price
            return True

    def make_payment(self, amount):
        """Process customer payment that reduces balance."""
        self._balance -= amount


class PredatorCreditCard(CreditCard):
    """An extension to CreditCard that compounds interest and fees."""

    def __init__(self, customer, bank, acnt, limit, apr):
        """Create a new predatory credit card instance.

        The initial balance is zero.

        customer the name of the customer (e.g., 'John Bowman')
        bank     the name of the bank (e.g., '1st Bank')
        acnt     the account identifier (e.g., '5456 7465 8748 7865')
        limit    credit limit (measured in dollars)
        apr      annual percentage rate (e.g., 0.0635 for 8.25% APR)
        """

        super().__init__(customer, bank, acnt, limit)
        self._apr = apr

    def charge(self, price):
        """Charge given price to the card, assuming sufficient credit limit.

        Return True if charge was processed.
        Return False and assess $5 fee if charge is denied.
        """
        success = super().charge(price)
        if not success:
            self._balance += 5
        return success

    def process_month(self):
        """Assess monthly interest on outstanding balance."""
        if self._balance > 0:
            # if positive balance, convert APR to monthly multiplicative factor
            monthly_factor = pow(1 + self._apr, 1/12)
            self._balance *= monthly_factor


if __name__ == '__main__':
    wallet = []
    wallet.append(CreditCard('John Doe', '1st Bank',
                  '5399 0375 9387 5309', 2500))
    wallet.append(CreditCard('Jane Doe', '2nd Bank',
                  '4599 0375 9387 5467', 2500))
    wallet.append(CreditCard('Mary Doe', '3rd Bank',
                  '2345 0375 6567 0967', 2500))

    for val in range(1, 17):
        wallet[0].charge(val)
        wallet[1].charge(2*val)
        wallet[2].charge(3*val)

    for c in range(3):
        print('Customer =', wallet[c].get_customer())
        print('Bank =', wallet[c].get_bank())
        print('Account =', wallet[c].get_account())
        print('Limit =', wallet[c].get_limit())
        print('Balance =', wallet[c].get_balance())
        while wallet[c].get_balance() > 100:
            wallet[c].make_payment(100)
            print('New balance =', wallet[c].get_balance())
        print()
