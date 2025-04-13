/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}",],
  theme: {
    extend: {
      colors: {
        'empowher-purple': '#d14189', 
        'empowher-blue': '#0aabbd', 
        'empowher-dark-blue': "#1c2a47",
        'empowher-orange': '#fb7f27',
      },
    },
  },
  plugins: [],
}

