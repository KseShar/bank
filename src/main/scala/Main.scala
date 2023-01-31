object Main {
  class BankAccount(initialBalance: Double) {
    protected var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = {
      balance += amount; balance
    }
    def withdraw(amount: Double) = {
      balance -= amount; balance
    }
  }

  class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance: Double) {
    private var count = 0
    private def comiss(a: Double) = {
      a * 0.01
    }
    override def deposit(amount: Double): Double = {
      if (count > 2) {
        balance = super.deposit(amount) - comiss(amount)
      }
      else balance = super.deposit(amount)
      count += 1
      balance
    }

    override def withdraw(amount: Double): Double = {
      if (count > 2) {
        balance = super.withdraw(amount) - comiss(amount)
      }
      else balance = super.withdraw(amount)
      count += 1
      balance
    }

    def earnMonthlyInterest(percent: Double) = {
      balance += balance * percent / 100
      count = 0
    }
  }
    def main(args: Array[String]):Unit =  {
      var acc = new SavingsAccount(0.0)
      acc.deposit(10.0)
      println(acc.currentBalance)
      acc.withdraw(3)
      println(acc.currentBalance)
      acc.deposit(10.0)
      println(acc.currentBalance)
      acc.deposit(10.0)
      println(acc.currentBalance)
      acc.earnMonthlyInterest(0.1)
      println(acc.currentBalance)
    }
}