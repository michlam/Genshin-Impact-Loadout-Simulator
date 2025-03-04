# Genshin Impact Loadout Simulator
A loadout simulator for Genshin Impact to help you try out and build new teams.

![Demo Gif](./Demo/DemoGif.gif "Demo Gif")

## Project Description
This project aims to implement a simulator for Genshin Impact teams, characters, and weapons, similar to what is seen in game. This project is also to help me practice my fullstack development and to help me learn Java, Spring, SQL, JavaScript, and React.

### Tools Used:
1. Visual Studio Code
2. IntelliJ IDEA
3. MySQL Workbench
4. Github
5. Postman

# Project Setup
### Tools Used
1. Visual Studio Code
2. IntelliJ IDEA
3. MySQL Workbench
4. Github
5. Postman

### Installation Steps
1. Clone the repository
   ```bash
   git clone https://github.com/michlam/Genshin-Impact-Loadout-Simulator.git
2. In MySQL Workbench, create a database named "genshin"
   ```bash
   create database genshin;
3. Create the following folders and files in the code
   ```bash
   /genshin-simulator-backend/src/main/
   /genshin-simulator-backend/src/main/application.properties
4. In application.properties, add this configuration to connect with your daatabase
   ```bash
   spring.application.name=genshin-simulator-backend
   spring.datasource.url=jdbc:mysql://*localhost:3306*/genshin
   spring.datasource.username=*username*
   spring.datasource.password=*password*

   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   spring.jpa.hibernate.ddl-auto=update
   ```
   Replace *localhost:3306*, *username*, and *password* with your corresponding values.

5. In IntelliJ IDEA, run the GenshinSimulatorBackendApplication.
6. In Visual Studio Code, go to "/genshin-simulator-frontend/" and run the following
   ```
   npm run dev
   ```
   You may need to install *react*, *react-router-dom*, and *vite* if you don't have them.


### Phase 1
For the first phase, I plan to start small and only implement the basic teams and characters, with very minimal statistical information. The following list summarizes the phase 1 planned features:
- Users can create, login to, and logout of their accounts
- Users can add a character to their account
- Users can create teams with up to four characters
- Users can create up to eight teams

### Technologies Used
- MySQL database setup for user accounts, characters, and teams
- Java and Spring backend, with the required REST APIs
- HTML, CSS, and JavaScript frontend that consumes the REST APIs

<br/>
<br/>

# Attributions
### Art
- All Genshin Import artwork from HoYoverse
### Icons
- <a target="_blank" href="https://coolshap.es/">Star</a> icon by CoolShap.es
- <a target="_blank" href="https://icons8.com/icon/37218/sort-down">Sort Down</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a>
- <a target="_blank" href="https://icons8.com/icon/37221/sort-up">Sort Up</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a>
