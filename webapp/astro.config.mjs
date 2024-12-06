// @ts-check
import { defineConfig, envField } from 'astro/config';

import tailwind from '@astrojs/tailwind';

import preact from '@astrojs/preact';

export default defineConfig({
  integrations: [tailwind(), preact()],
  // @ts-ignore
  env: {
    schema: {
      API_SERVER: envField.string({context: 'client', access: 'public'}),
    }
  },
});