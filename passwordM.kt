import java.util.*

// PasswordManager class to manage passwords
class PasswordManager {
    // Mutable map to store username and password pairs
    private val credentials = mutableMapOf<String, String>()

    // Function to add new credentials
    fun addCredentials(username: String, password: String) {
        credentials[username] = password
    }

    // Function to retrieve password for a given username
    fun getPassword(username: String): String? {
        return credentials[username]
    }

    // Function to display all credentials
    fun displayAllCredentials() {
        println("All Users and Passwords:")
        for ((user, pass) in credentials) {
            println("Username: $user, Password: $pass")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val passwordManager = PasswordManager()

    var continueLoop = true

    // Loop until the user chooses to end the program
    while (continueLoop) {
        println("Menu:")
        println("1. Add User and Password")
        println("2. Display All Users and Passwords")
        println("3. Exit")
        print("Enter your choice: ")
        val choice = scanner.nextInt()

        when (choice) {
            1 -> {
                print("Enter username: ")
                val username = scanner.next()
                print("Enter password: ")
                val password = scanner.next()
                passwordManager.addCredentials(username, password)
                println("User and password added successfully.")
            }
            2 -> {
                passwordManager.displayAllCredentials()
            }
            3 -> {
                continueLoop = false
                println("Exiting program.")
            }
            else -> println("Invalid choice. Please enter a number from 1 to 3.")
        }

        // Check if the user wants to continue
        if (continueLoop) {
            print("Do you want to continue? (yes/no): ")
            val continueChoice = scanner.next()
            continueLoop = continueChoice.equals("yes", ignoreCase = true)
        }
    }
}
