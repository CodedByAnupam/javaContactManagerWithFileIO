public class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name,String phone,String email)
    {
                if (!validName(name))
                {
                    throw new IllegalArgumentException("Invalid name");
                }
                if (!validPhone(phone))
                {
                    throw new IllegalArgumentException("Invalid Phone");
                }
                if (!validEmail(email))
                {
                    throw new IllegalArgumentException("Invalid email");
                }
        
                this.name = name;
                this.phone = phone;
                this.email = email;
        
                
            }
        
            private boolean validName(String name) {
                return name != null && !name.trim().isEmpty(); 
               
            }
            
            private boolean validPhone(String phone) {
                if (phone == null || phone.isEmpty()) {
                    return false;
                }
                String cleanPhone = phone.replace(" ", "").replace("-", "");

                return cleanPhone.length() == 10 && cleanPhone.matches("\\d{10}");

            }
            
            private boolean validEmail(String email) {
                if (email == null || email.isEmpty()) {
                    return false;
                }

                return email.contains("@") && email.contains(".");
            }

            public String getName() {
                return this.name;
            }
            
            public String getPhone() {
                return this.phone;
            }
            
            public String getEmail() {
                return this.email;
            }

            
            public String toString() {
                return "\nname: " + this.name + " phone: " + this.phone + " email: " + this.email + "\n";
            }
}
