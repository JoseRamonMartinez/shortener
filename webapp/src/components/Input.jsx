export default function Input({ origin, setOrigin, onSubmit, loading }) {
  const handleFormSubmit = (e) => {
    e.preventDefault();
    if (origin) {
      onSubmit(origin);
    }
  };

  return (
    <form onSubmit={handleFormSubmit} class="flex flex-col rounded-lg space-y-6 p-6 bg-gray-800">
      <div>
        <label for="origin" class="block text-gray-400 text-sm font-semibold mb-2">
          Paste your URL here:
        </label>
        <input
          type="url"
          id="origin"
          name="origin"
          value={origin}
          onInput={(e) => setOrigin(e.target.value)}
          required
          placeholder="https://example.com"
          class="w-full px-4 py-3 text-gray-900 rounded-lg focus:outline-none focus:ring-2 focus:ring-purple-500 shadow-sm"
        />
      </div>
      <button
        type="submit"
        class="w-full bg-gradient-to-r from-purple-500 to-purple-700 hover:from-purple-600 hover:to-purple-800 text-white font-bold py-3 rounded-lg shadow-lg transition-all duration-300 focus:outline-none focus:ring-2 focus:ring-purple-400 focus:ring-offset-2 focus:ring-offset-gray-900"
      >
        {loading ? 'Loading...' : '✨ Shorten!'}
      </button>
    </form>
  );
}
