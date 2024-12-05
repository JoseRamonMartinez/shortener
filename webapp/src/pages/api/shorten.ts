import type { APIRoute } from 'astro';
import { API_SERVER, API_KEY } from 'astro:env/server';

export const post: APIRoute = async ({ request }) => {
  try {
    // Read the client's request body
    const clientBody = await request.json();

    // Forward the request to the external API
    const response = await fetch(API_SERVER, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'X-Api-Key': `${API_KEY}`,
      },
      body: JSON.stringify(clientBody), // Forward the client's data
    });

    // Get the external API's response and return it
    const data = await response.json();
    return new Response(JSON.stringify(data), {
      status: response.status,
      headers: {
        'Content-Type': 'application/json',
      },
    });
  } catch (error) {
    console.error('Proxy error:', error);
    return new Response(
      JSON.stringify({ error: 'Failed to fetch data from external API' }),
      {
        status: 500,
        headers: { 'Content-Type': 'application/json' },
      }
    );
  }
};
