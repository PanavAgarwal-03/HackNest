package src.models;



class Admin extends User{

    public Admin(int userId, String username, String password) {
        super(userId, username, password);
    }

    public void displayAdminPanel() {
        System.out.println("Welcome, Admin " + getUsername() + ". You have full access.");
    }
}