import java.util.Scanner
import java.io.BufferedReader
import java.util.*

// Class to hold user credentials
data class User(val username: String, val password: String)

// Password manager class
class PasswordManager 
{
    private val users = mutableListOf<User>()
    private val scanner = Scanner(System.`in`)

    // Function to add user
    fun addUser() 
    {
        println("Enter username:")
        val username = scanner.nextLine()
        println("Enter password:")
        val password = scanner.nextLine()
        users.add(User(username, password))
        println("User added successfully!")
    }

    // Function to show all users
    fun showUsers() 
    {
        if (users.isEmpty()) 
        {
            println("No users saved.")
            return
        }
        println("Saved users:")
        for (user in users) 
        {
            println("Username: ${user.username}, Password: ${user.password}")
        }
    }
}

fun main(args : Array<String>) 
{
    val passwordManager = PasswordManager()
    val scanner = Scanner(System.`in`)
    
    var continueProgram = true

    while (continueProgram) 
    {
        println("\nPassword Manager Menu:")
        println("1. Add User")
        println("2. Show Users")
        println("3. Exit")
        println("Enter your choice: ")
        val choice = scanner.nextInt()

        when (choice) 
        {
            1 -> 
            {
                passwordManager.addUser()
                println("Do you want to add another user? (yes/no)")
                val answer = scanner.next()
                continueProgram = answer == "yes"
            }
            2 -> 
            {
                passwordManager.showUsers()
            }
            3 -> 
            {
                println("Exiting Password Manager.")
                continueProgram = false
            }
            else -> 
            {
                println("Invalid choice, please try again.")
            }
        }
    }
}
