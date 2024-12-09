# Stage 1: Build the app
FROM node:lts AS build

# Set working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Build the Astro app
RUN npm run build

# Stage 2: Set up the Nginx server to serve the app
FROM nginx:alpine AS runtime

# Copy the built Astro app to the Nginx public directory
COPY --from=build /app/dist /usr/share/nginx/html

# Expose port 80 (default for Nginx)
EXPOSE 80

# Start Nginx server
CMD ["nginx", "-g", "daemon off;"]
