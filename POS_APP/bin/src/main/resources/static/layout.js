/* ============================================================
   VANTA POS — Shared Layout Injector
   Injects sidebar, header, modals, toast and shared JS
   ============================================================ */

// ── Page map: pageId → { file, title, parent } ─────────────
const PAGE_MAP = {
  'dashboard':        { file: 'pages/main/dashboard.html', title: 'Dashboard',                 parent: null },
  'pos-terminal':     { file: 'pages/main/pos-terminal.html',  title: 'POS Terminal',          parent: null },
  // Users & Roles
  'cashiers':         { file: 'pages/users/cashiers.html',      title: 'Cashier Accounts',     parent: 'users' },
  'roles':            { file: 'pages/users/roles.html',         title: 'Roles & Permissions',  parent: 'users' },
  'activity-log':     { file: 'pages/users/activity-log.html',  title: 'Activity Log',         parent: 'users' },
  // Products
  'catalog':          { file: 'pages/products/catalog.html',       title: 'Product Catalog',    parent: 'products' },
  'categories':       { file: 'pages/products/categories.html',    title: 'Categories',         parent: 'products' },
  'barcodes':         { file: 'pages/products/barcodes.html',      title: 'Barcode / SKU',      parent: 'products' },
  'batch-expiry':     { file: 'pages/products/batch-expiry.html',  title: 'Batch & Expiry',     parent: 'products' },
  'stock-movement':   { file: 'pages/products/stock-movement.html',title: 'Stock In / Out',     parent: 'products' },
  // Sales & Billing
  'transactions':     { file: 'pages/sales/transactions.html',  title: 'Transactions',          parent: 'sales' },
  'invoices':         { file: 'pages/sales/invoices.html',      title: 'Invoices / Receipts',   parent: 'sales' },
  'held-orders':      { file: 'pages/sales/held-orders.html',   title: 'Held Orders',           parent: 'sales' },
  'returns':          { file: 'pages/sales/returns.html',       title: 'Returns & Refunds',     parent: 'sales' },
  // Customers
  'customers':        { file: 'pages/customers/customers.html',     title: 'Customer Directory', parent: 'customers' },
  'purchase-history': { file: 'pages/customers/purchase-history.html', title: 'Purchase History', parent: 'customers' },
  'loyalty-points':   { file: 'pages/customers/loyalty-points.html',title: 'Loyalty Points',    parent: 'customers' },
  'memberships':      { file: 'pages/customers/memberships.html',   title: 'Memberships / VIP',  parent: 'customers' },
  // Suppliers
  'suppliers':        { file: 'pages/suppliers/suppliers.html',     title: 'Supplier Directory', parent: 'suppliers' },
  'purchase-orders':  { file: 'pages/suppliers/purchase-orders.html',title: 'Purchase Orders',   parent: 'suppliers' },
  'restock-alerts':   { file: 'pages/suppliers/restock-alerts.html',title: 'Restock Alerts',     parent: 'suppliers' },
  'supplier-payments':{ file: 'pages/suppliers/supplier-payments.html', title: 'Supplier Payments', parent: 'suppliers' },
  // Payment & Accounting
  'cash-register':    { file: 'pages/payment/cash-register.html', title: 'Cash Register',       parent: 'payment' },
  'reconciliation':   { file: 'pages/payment/reconciliation.html',title: 'Reconciliation',      parent: 'payment' },
  'ap-ar':            { file: 'pages/payment/ap-ar.html',         title: 'AP / AR',             parent: 'payment' },
  'tax-reports':      { file: 'pages/payment/tax-reports.html',   title: 'Tax Reports',         parent: 'payment' },
  // Reports
  'sales-report':     { file: 'pages/reports/sales-report.html',  title: 'Sales Reports',       parent: 'reports' },
  'stock-report':     { file: 'pages/reports/stock-report.html',  title: 'Stock Reports',       parent: 'reports' },
  'pl-report':        { file: 'pages/reports/pl-report.html',     title: 'Profit & Loss',       parent: 'reports' },
  'custom-report':    { file: 'pages/reports/custom-report.html', title: 'Custom Builder',      parent: 'reports' },
  // Promotions
  'offers':           { file: 'pages/promos/offers.html',        title: 'Offers & Combos',      parent: 'promos' },
  'coupons':          { file: 'pages/promos/coupons.html',       title: 'Coupon Codes',         parent: 'promos' },
  'happy-hour':       { file: 'pages/promos/happy-hour.html',    title: 'Happy Hour',           parent: 'promos' },
  // Loyalty
  'points-config':    { file: 'pages/loyalty/points-config.html', title: 'Points Config',       parent: 'loyalty' },
  'tier-management':  { file: 'pages/loyalty/tier-management.html',title: 'Tier Management',    parent: 'loyalty' },
  'retention':        { file: 'pages/loyalty/retention.html',     title: 'Retention Tracking',  parent: 'loyalty' },
  // Hardware
  'devices':          { file: 'pages/hardware/devices.html',       title: 'Devices & Printers', parent: 'hardware' },
  'cash-drawer':      { file: 'pages/hardware/cash-drawer.html',   title: 'Cash Drawer',        parent: 'hardware' },
  'qr-mobile':        { file: 'pages/hardware/qr-mobile.html',     title: 'QR / Mobile Pay',    parent: 'hardware' },
};

// ── Sidebar HTML ────────────────────────────────────────────
function buildSidebar(activePage) {
  const ap = activePage || 'dashboard';
  const info = PAGE_MAP[ap] || {};
  const activeParent = info.parent;

  function navItem(id, icon, label, file) {
    const isActive = ap === id;
    return `
    <div class="nav-item">
      <button class="nav-link${isActive ? ' page-active' : ''}" onclick="navigate('${file}')">
        <span class="nav-icon"><i class="bi ${icon}"></i></span>
        <span>${label}</span>
      </button>
    </div>`;
  }

  function navGroup(groupId, icon, label, items) {
    const isOpen = activeParent === groupId;
    const linksHTML = items.map(([id, lbl]) => {
      const isActive = ap === id;
      const file = PAGE_MAP[id]?.file || '#';
      return `<a class="${isActive ? 'page-active' : ''}" onclick="navigate('${file}')">${lbl}</a>`;
    }).join('');
    return `
    <div class="nav-item">
      <button class="nav-link${isOpen ? ' open' : ''}" onclick="toggleMenu(this)">
        <span class="nav-icon"><i class="bi ${icon}"></i></span>
        <span>${label}</span>
        <span class="nav-arrow"><i class="bi bi-chevron-right"></i></span>
      </button>
      <div class="nav-submenu${isOpen ? ' open' : ''}">
        ${linksHTML}
      </div>
    </div>`;
  }

  return `
  <nav id="sidebar">
    <div class="sidebar-logo">
      <div class="logo-mark">🛒</div>
      <div class="logo-wordmark">Vanta<sub>POS System</sub></div>
    </div>
    <div class="sidebar-nav">
      <div class="nav-section-label">Main</div>
      ${navItem('dashboard', 'bi-grid-fill', 'Dashboard', 'pages/main/dashboard.html')}
      ${navItem('pos-terminal', 'bi-display', 'POS Terminal', 'pages/main/pos-terminal.html')}
      ${navGroup('users', 'bi-people-fill', 'Users &amp; Roles', [
        ['cashiers','Cashier Accounts'],['roles','Roles & Permissions'],['activity-log','Activity Log']
      ])}
      ${navGroup('products', 'bi-box-seam-fill', 'Products', [
        ['catalog','Product Catalog'],['categories','Categories'],['barcodes','Barcode / SKU'],
        ['batch-expiry','Batch & Expiry'],['stock-movement','Stock In / Out']
      ])}
      ${navGroup('sales', 'bi-receipt-cutoff', 'Sales &amp; Billing', [
        ['transactions','Transactions'],['invoices','Invoices / Receipts'],
        ['held-orders','Held Orders'],['returns','Returns & Refunds']
      ])}
      ${navGroup('customers', 'bi-person-heart', 'Customers (CRM)', [
        ['customers','Customer Directory'],['purchase-history','Purchase History'],
        ['loyalty-points','Loyalty Points'],['memberships','Memberships / VIP']
      ])}
      ${navGroup('suppliers', 'bi-truck', 'Suppliers', [
        ['suppliers','Supplier Directory'],['purchase-orders','Purchase Orders'],
        ['restock-alerts','Restock Alerts'],['supplier-payments','Payments']
      ])}
      ${navGroup('payment', 'bi-cash-stack', 'Payment &amp; Accounting', [
        ['cash-register','Cash Register'],['reconciliation','Reconciliation'],
        ['ap-ar','AP / AR'],['tax-reports','Tax Reports']
      ])}
      <div class="nav-section-label">Reports</div>
      ${navGroup('reports', 'bi-bar-chart-fill', 'Reports &amp; Analytics', [
        ['sales-report','Sales Reports'],['stock-report','Stock Reports'],
        ['pl-report','Profit & Loss'],['custom-report','Custom Builder']
      ])}
      ${navGroup('promos', 'bi-tags-fill', 'Promotions', [
        ['offers','Offers & Combos'],['coupons','Coupon Codes'],['happy-hour','Happy Hour']
      ])}
      ${navGroup('loyalty', 'bi-star-fill', 'Loyalty &amp; Membership', [
        ['points-config','Points Config'],['tier-management','Tier Management'],['retention','Retention Tracking']
      ])}
      ${navGroup('hardware', 'bi-cpu-fill', 'Hardware', [
        ['devices','Devices & Printers'],['cash-drawer','Cash Drawer'],['qr-mobile','QR / Mobile Pay']
      ])}
    </div>
    <div class="sidebar-footer">
      <div class="sf-avatar">AK</div>
      <div class="sf-info">
        <div class="sf-name">Adam Khan</div>
        <div class="sf-role">Store Manager</div>
      </div>
      <button style="background:none;border:none;color:rgba(255,255,255,0.3);cursor:pointer;font-size:14px;" title="Logout"><i class="bi bi-box-arrow-right"></i></button>
    </div>
  </nav>`;
}

// ── Header HTML ─────────────────────────────────────────────
function buildHeader(title) {
  return `
  <header id="header">
    <button class="header-toggle" onclick="toggleSidebar()"><i class="bi bi-list"></i></button>
    <div class="header-breadcrumb">
      <i class="bi bi-shop" style="color:var(--amber)"></i>
      <span class="hb-sep">/</span>
      <span class="hb-current">${title || 'Dashboard'}</span>
    </div>
    <div class="header-search">
      <span class="hs-icon"><i class="bi bi-search"></i></span>
      <input type="text" placeholder="Search products, orders…" />
    </div>
    <div class="header-actions">
      <div class="h-btn" title="Notifications"><i class="bi bi-bell"></i><span class="h-badge">3</span></div>
      <div class="h-btn" title="Low Stock Alerts" onclick="navigate('pages/suppliers/restock-alerts.html')">
        <i class="bi bi-exclamation-triangle"></i><span class="h-badge" style="background:var(--amber)">5</span>
      </div>
      <button class="h-pos-btn" onclick="navigate('pages/main/pos-terminal.html')">
        <i class="bi bi-display"></i> Open POS
      </button>
    </div>
  </header>`;
}

// ── Shared Modals ───────────────────────────────────────────
function buildModals() {
  return `
  <!-- Delete Confirm -->
  <div id="modal-delete" class="pos-modal-bg">
    <div class="pos-modal" style="max-width:380px">
      <div class="modal-hd">
        <div class="modal-hd-title" style="color:var(--rose)"><i class="bi bi-trash3 me-2"></i>Confirm Delete</div>
        <div class="modal-x" onclick="closeModal('modal-delete')">×</div>
      </div>
      <div class="modal-body">
        <p style="color:var(--text-secondary)">Are you sure you want to delete this <strong id="del-target" style="color:var(--text-primary)">record</strong>? This cannot be undone.</p>
      </div>
      <div class="modal-ft">
        <button class="btn-pos btn-outline-dark" onclick="closeModal('modal-delete')">Cancel</button>
        <button class="btn-pos btn-rose" onclick="deleteConfirmed()"><i class="bi bi-trash3"></i> Delete</button>
      </div>
    </div>
  </div>
  <!-- Toast -->
  <div class="toast-wrap" id="toast-container"></div>`;
}

// ── Shared JS Functions ─────────────────────────────────────
function sharedJS() {
  return `
  <script>
    // ── Navigation ──
    function navigate(file) {
      // Resolve relative to root
      const base = window.location.pathname.includes('/pages/') ? '../' : './';
      window.location.href = base + file;
    }

    // ── Sidebar toggle ──
    function toggleSidebar() {
      document.getElementById('sidebar').classList.toggle('collapsed');
    }

    function toggleMenu(btn) {
      const sub = btn.nextElementSibling;
      const open = sub.classList.contains('open');
      document.querySelectorAll('.nav-submenu.open').forEach(m => {
        m.classList.remove('open');
        m.previousElementSibling.classList.remove('open');
      });
      if (!open) { sub.classList.add('open'); btn.classList.add('open'); }
    }

    // ── Modals ──
    function openModal(id) { document.getElementById(id)?.classList.add('show'); }
    function closeModal(id) { document.getElementById(id)?.classList.remove('show'); }
    document.querySelectorAll('.pos-modal-bg').forEach(m =>
      m.addEventListener('click', e => { if (e.target === m) m.classList.remove('show'); })
    );
    document.addEventListener('keydown', e => {
      if (e.key === 'Escape') document.querySelectorAll('.pos-modal-bg.show').forEach(m => m.classList.remove('show'));
    });

    let delTarget = '';
    function confirmDel(type) { delTarget = type; document.getElementById('del-target').textContent = type; openModal('modal-delete'); }
    function deleteConfirmed() { closeModal('modal-delete'); showToast(delTarget + ' deleted', 'success'); }
    function saveForm(id) { closeModal(id); showToast('Record saved successfully', 'success'); }

    // ── Toast ──
    function showToast(msg, type = 'info') {
      const t = document.createElement('div');
      t.className = 'pos-toast ' + type;
      const icon = type === 'success' ? '✓' : type === 'error' ? '✕' : 'i';
      t.innerHTML = '<span style="font-weight:700;font-size:15px">' + icon + '</span> ' + msg;
      document.getElementById('toast-container').appendChild(t);
      setTimeout(() => { t.style.opacity = '0'; t.style.transform = 'translateX(12px)'; t.style.transition = '0.3s'; }, 2500);
      setTimeout(() => t.remove(), 2900);
    }

    // ── Table filter ──
    function filterTable(input, tableId) {
      const q = input.value.toLowerCase();
      document.querySelectorAll('#' + tableId + ' tbody tr').forEach(r => {
        r.style.display = r.textContent.toLowerCase().includes(q) ? '' : 'none';
      });
    }

    // ── Pagination ──
    document.querySelectorAll('.pos-pagination').forEach(pg => {
      pg.addEventListener('click', e => {
        const btn = e.target.closest('.pg-n');
        if (btn && !btn.querySelector('.bi-chevron-right')) {
          pg.querySelectorAll('.pg-n').forEach(b => b.classList.remove('active'));
          btn.classList.add('active');
        }
      });
    });
  <\/script>`;
}

// ── Page skeleton builder ───────────────────────────────────
function buildPageShell(pageId, title, contentHTML, extraModals, extraScript, cssPath) {
  const css = cssPath || '../pos-styles.css';
  return `<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>${title} — VANTA POS</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="${css}" />
</head>
<body>
  ${buildSidebar(pageId)}
  ${buildHeader(title)}
  <main id="main">
    ${contentHTML}
  </main>
  ${buildModals()}
  ${extraModals || ''}
  ${sharedJS()}
  ${extraScript || ''}
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"><\/script>
</body>
</html>`;
}
