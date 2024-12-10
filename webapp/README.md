<h1 align="center">SHORTENER WEBAPP </h1>
<h3 align="center">

![Astro](https://img.shields.io/badge/astro-%232C2052.svg?style=for-the-badge&logo=astro&logoColor=white)
![TailwindCSS](https://img.shields.io/badge/tailwindcss-%2338B2AC.svg?style=for-the-badge&logo=tailwind-css&logoColor=white)
![Preact](https://img.shields.io/badge/preact-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%23673AB8)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)

</h3>
<br>

# Description 📢

The URL Shortener WebApp is a modern web application that allows users to shorten long URLs into easily shareable, concise links. The application provides a user-friendly interface for inputting URLs, generating short URLs, and displaying the shortened URLs.

<br>

# Deployment 🚀

| Environment         | URL                                  |
|-----------------|:-------------------------------------|
| Local           | https://localhost:4312               |
| Local with docker | https://localhost:80               |
| Local with docker-compose | https://localhost:3000               |
| Production      | https://shortener-5da0.onrender.com  |
 

<br>

# Project structure 📋

```
public/                                    Static files of the application
src/                                       Source code of the project
├─ components/                             Reusable components of the application
├─ layouts/                                Layouts of the application
└── pages/                                 Entry points of the application
.astro.config.mjs                          Configuration file of Astro
Dockerfile                                 Configuration file of Docker
package.json                               Configuration file of pnpm
pnpm-lock.yaml                             Configuration file of pnpm
tailwind.config.cjs                        Configuration file of Tailwind
tsconfig.json                              Configuration file of TypeScript
```

<br>

# Scripts 📌

| Task                                      | Description                                                                        |
|--------------------------------------------|----------------------------------------------------------------------------------------|
| `pnpm run start`                           | Start the application in development mode                                              |
| `pnpm run buld`                            | Create the build of the project                                                        |

**NOTE:** To run this application without Docker compose you need to pass .env variables to the run command. .env files should be like this:

```
API_SERVER=http://localhost:8080
```

<br>